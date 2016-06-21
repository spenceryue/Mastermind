package assignment2;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends GameConfiguration {
	Code secret;
	Random generator;
	
	public Computer () {
		generator = new Random();
		String[] code = new String[pegNumber];
		for (int i=0; i<pegNumber; i++) {
			int index = generator.nextInt(colors.length);
			code[i] = colors[index];
		}
		
		secret = new Code(code);
	}
	
	/**
	 * @param c, code to check against secret
	 * @return, array of {#black pegs, #white pegs}
	 */
	public int[] checkGuess(Code c) {
		int black = 0;
		int white = 0;
		
		ArrayList<String> remainingGuess = new ArrayList<String>(pegNumber);
		ArrayList<String> remainingSecret = new ArrayList<String>(pegNumber);
		boolean[] comparison = c.compare(secret);
		
		for (int i=0; i<pegNumber; i++)
			if (comparison[i]) {
				remainingSecret.add(secret.getPegs()[i]);
				black++;
			}
			else
				remainingGuess.add(c.getPegs()[i]);
		
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
	 * @return secret Code
	 */
	public Code getSecret() {
		return secret;
	}
}
