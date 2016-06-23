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

public class Game extends GameConfiguration {
	private ArrayList<String> history;
	private int round;
	private boolean testing;
	private boolean playing;
	private int guessNumber;
	private String[] colors;
	private int pegNumber;

	public Game() {
		this(false);
	}

	public Game(boolean testing) {
		this.testing = testing;
		guessNumber = GameConfiguration.guessNumber;
		colors = GameConfiguration.colors;
		pegNumber = GameConfiguration.pegNumber;
		history = new ArrayList<String>(guessNumber);
		round = 0;
		playing = false;
	}

	public void showHistory() {
		if (history.isEmpty())
			System.out.println("\nNo history to show.\n");
		System.out.println();
		for (int i = 0; i < history.size(); i++)
			System.out.println("turn "+(i+1)+": \t"+history.get(i));
		System.out.println();
	}

	public void addHistory(String feedback) {
		history.add(feedback);
	}

	public String feedback(String guess, int[] result) {
		String feedback = guess + Message.prompt("result");

		// check for win
		if (result[0] == 4) {
			playing = false;
			feedback += Message.prompt("win");
			round = -1; // for flag purposes
			return feedback;
		}

		// check for loss
		if (round == guessNumber) {
			playing = false;
			feedback += Message.prompt("lose");
			return feedback;
		}

		// single or plural black?
		if (result[0] == 1)
			feedback += Message.prompt("black1");
		else if (result[0] > 1)
			feedback += String.format(Message.prompt("blackx"), result[0]);

		// " and "?
		if (result[0] != 0 && result[1] != 0)
			feedback += " and ";

		// single or plural white?
		if (result[1] == 1)
			feedback += Message.prompt("white1");
		else if (result[1] > 1)
			feedback += String.format(Message.prompt("whitex"), result[1]);

		// no black, no white?
		else if (result[0] == 0 && result[1] == 0)
			feedback += Message.prompt("noPegs");

		System.out.println();
		return feedback;
	}

	public int getRound() {
		return round;
	}

	public int addRound() {
		return ++round;
	}

	public int runGame(int count) {
		if (count==-1)
			return -1; // abort
		
		Player p = new Player();
		Computer comp = new Computer(testing);
		round = 1;
		playing = true;
		
		// print intro
		if (count == 1)
			System.out.print( Message.intro(pegNumber, colors.length, GameConfiguration.colorsString) );
		else
			System.out.println("\n\t>>Starting new game<<\n");
		
		// prompt player "ready?"
		System.out.print( Message.start(guessNumber) );
		if ( !p.startGame() )
			return -1;
		System.out.println();
		
		// print "generating secret code...."
		// show code if testing is true;
		Message.generating();
		if (testing)
			System.out.format("      (for this game the secret code is %s)", comp.getSecret());
		System.out.println("\n");
		
		// print rounds left
		do {
			System.out.println( Message.roundsLeft(round-1, guessNumber) );
			Code c = null;
			String guess = null;
			
			// guess code
			do {
				System.out.print( Message.prompt("guess") );
				guess = p.guess();
				
				// check for showHistory flag (null)
				if ( !(guess instanceof String) ) {
					showHistory();
					continue;
				}
				
				// validate guess
				try {
					c = new Code(guess);
				} catch (IllegalArgumentException e) {
					System.out.println( guess + Message.prompt("invalid"));
					System.out.println();
					continue;
				}
				break;
			} while (true);
			
			// generate feedback
			int[] result = comp.checkGuess(c);
			String feedback = feedback(guess,result);
			
			// add turn to history
			addHistory(feedback);
			
			// print feedback
			System.out.println(feedback +"\n");
			
			// increment turn
			addRound();
		} while (playing);
		
		// show secret code if lost
		if (round != 0)
			System.out.format("(Secret code was: %s)\n", comp.getSecret());
		
		// prompt "another game?"
		System.out.print( Message.prompt("another") );
		int again = p.playAnother() ? ++count : -1;
		return new Game(testing).runGame(again);
	}
}
