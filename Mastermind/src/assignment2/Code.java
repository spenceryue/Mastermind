package assignment2;

public class Code {
	private static final int pegNumber = GameConfiguration.pegNumber;
	private static final String[] colors = GameConfiguration.colors;
	private String [] pegs = new String[pegNumber];

	public Code(String[] pegs) {
		// check validity of input (size)
		if (pegs.length != pegNumber)
			throw new IllegalArgumentException();
		
		// check validity of input (colors)
		for (String color: pegs) {
			boolean found = false;
			for (String allowedColor : colors)
				if (allowedColor.toLowerCase().startsWith(color.toLowerCase())) {
					found = true;
					break;
				}
			if (!found)
				throw new IllegalArgumentException();
		}
		
		this.pegs = pegs;
	}
	
	/**
	 * 
	 * @param c, Code to be compared to
	 * @return, array of booleans indicating a match or not
	 */
	public boolean[] compare(Code c) {
		
	}
}
