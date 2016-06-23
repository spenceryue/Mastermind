package assignment2;

/**
 * Spencer Yue
 * sty223
 * (No partner)
 * https://github.com/spenceryue/mastermind
 * Slip days used: <0>
 * Summer 2016
 */

public class Message {
	// needs formatting
	private static String intro = "Welcome to Mastermind.  Here are the rules.%n%n"
			+ "   This is a text version of the classic board game Mastermind. The computer will think of a secret code. The code consists of %d colored pegs.%n"
			+ "The pegs MUST be one of %d colors: %s. A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in.   After you make a valid guess the result (feedback) will be displayed.%n"
			+ "The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  For each peg in the guess that is the correct color, but is out of position, you get a white peg.  For each peg that is fully incorrect, you get no feedback.%n"
			+ "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.%n"
			+ "When entering guesses you only need to enter the first character of each color as a capital letter.%n%n";

	// needs formatting
	private static String start = "You have %d guesses to figure out the secret code or you lose the game.  Are you ready to play? (Y/N): ";
	
	private static String generating = "Generating secret code ....";

	// needs formatting
	private static String roundsLeft = "You have %d guesses left.";
	
	private static String guess = "What is your next guess?\n"
			+ "Type in the characters for your guess and press enter.\n" + "Enter guess: ";

	private static String result = " ->  Result: ";

	private static String noPegs = "No pegs";

	private static String invalid = " -> INVALID GUESS";

	private static String black1 = "1 black peg";

	// needs formatting
	private static String blackx = "%d black pegs";
	
	private static String white1 = "1 white peg";

	// needs formatting
	private static String whitex = "%d white pegs";

	private static String win = " – You win!!";

	private static String lose = " – Sorry, you are out of guesses. You lose, boo-hoo.";

	private static String another = "Are you ready for another game (Y/N): ";

	private static String[] key = { "intro", "start", "generating", "roundsLeft", "guess", "result",
			"noPegs", "invalid", "black1", "blackx", "white1", "whitex", "win", "lose", "another" };

	private static String[] bank = { intro, start, generating, roundsLeft, guess, result, noPegs, invalid,
			black1, blackx, white1, whitex, win, lose, another };
	
	// fill-in-the-blank formatter methods
	
	public static String intro(int pegNumber, int colorsLength, String colorsString) {
		return String.format(intro, pegNumber, colorsLength, colorsString);
	}
	public static String start(int guessNumber) {
		return String.format(start, guessNumber);
	}
	public static void generating () {
		System.out.print( generating.substring(0,generating.length()-4) );
		try {
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
		} catch (InterruptedException e1) {e1.printStackTrace();}
	}
	public static String roundsLeft(int round, int guessNumber){
		return (guessNumber-round==0) ? "" : String.format(roundsLeft, guessNumber-round);
	}
	public static String blackx(int numBlack){
		return String.format(blackx, numBlack);
	}
	public static String whitex(int numWhite){
		return String.format(whitex, numWhite);
	}

	/**
	 * 
	 * @param msgNum,
	 *            index of message in bank array
	 * @return message requested or empty string if not found
	 */
	public static String prompt(int msgNum) {
		if (msgNum < bank.length)
			return bank[msgNum];
		return "";
	}

	/**
	 * 
	 * @param msgName, name of message in key array
	 * @return message requested or empty string if not found
	 */
	public static String prompt(String msgName) {
		for (int i = 0; i < key.length; i++)
			if (key[i].toLowerCase().equals(msgName.toLowerCase()))
				return bank[i];
		return "";
	}

}
