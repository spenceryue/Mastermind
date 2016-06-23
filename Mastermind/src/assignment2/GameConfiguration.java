package assignment2;


/** Spencer Yue
 * sty223
 * (No partner)
 * https://github.com/spenceryue/mastermind
 * Slip days used: <0>
 * Summer 2016
 */

public class GameConfiguration {
	public static final int guessNumber = 12;
	public static final String[] colors = {"B","G","O","P","R","Y"};
	public static final int pegNumber = 4;
	
	public static String colorsString = "blue, green, orange, purple, red, or yellow";
	// ^ This is necessary to print adaptive instructions.
	// (Otherwise there is no way to infer from just the colors array what the full names
	// of the colors to be allowed in a given game configuration are.)
}
