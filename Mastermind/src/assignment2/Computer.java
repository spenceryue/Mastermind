package assignment2;

/**
 * Spencer Yue
 * sty223
 * (No partner)
 * https://github.com/spenceryue/mastermind
 * Slip days used: <0>
 * Summer 2016
 */

import java.util.ArrayList;
import java.util.Random;

public class Computer {
	private Code secret;
	private Random generator;
	private String[] colors = GameConfiguration.colors;
	private int pegNumber = GameConfiguration.pegNumber;
	
	public Computer (boolean testing) {
		generator = new Random();
		StringBuffer pegs = new StringBuffer(pegNumber);
		for (int i=0; i<pegNumber; i++) {
			int index = generator.nextInt(colors.length);
			pegs.append(colors[index]);
		}
		
		secret = new Code(pegs.toString());
	}
	
	/**
	 * @param c, code to check against secret
	 * @return, array of {#black pegs, #white pegs}
	 */
	public int[] checkGuess(Code c) {
		int black = 0;
		int white = 0;
		
		ArrayList<String> remainingSecret = new ArrayList<String>(pegNumber);
		ArrayList<String> remainingGuess = new ArrayList<String>(pegNumber);
		boolean[] comparison = c.compare(secret);
		
		for (int i=0; i<pegNumber; i++)
			if (comparison[i])
				black++;
			else {
				remainingSecret.add(secret.getPegs()[i]);
				remainingGuess.add(c.getPegs()[i]);
			}
		
		for (String peg : remainingGuess)
			for (int i=0; i<remainingSecret.size(); i++)
				if (remainingSecret.get(i).equals(peg)) {
					remainingSecret.remove(i--);
					white++;
				}
		
		int[] result = {black, white};
		return result;
	}
	
	/**
	 * 
	 * @return secret Code if testing, or null if not
	 */
	public Code getSecret() {
		return secret;
	}
}
