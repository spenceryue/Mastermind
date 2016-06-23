package assignment2;

/**
 * Spencer Yue
 * sty223
 * (No partner) 
 * https://github.com/spenceryue/mastermind 
 * Slip days used: <0> 
 * Summer 2016
 */

public class Code {
	private String[] pegs;
	private String[] colors = GameConfiguration.colors;
	private int pegNumber = GameConfiguration.pegNumber;
	
	/**
	 * 
	 * @param pegs,
	 *            input array of code
	 * @throws IllegalArgumentException
	 *             if input is wrong size or contains invalid colors.
	 */
	public Code(String pegs) {
		this.pegs = new String[pegNumber];

		// check validity of input (size)
		if (pegs.length() != pegNumber)
			throw new IllegalArgumentException();

		for (int i = 0; i < pegNumber; i++)
			this.pegs[i] = pegs.substring(i, i + 1).toUpperCase();

		// check validity of input (colors)
		for (String color : this.pegs) {
			boolean found = false;
			for (String allowedColor : colors)
				if (allowedColor.toUpperCase().startsWith(color)) {
					found = true;
					break;
				}
			if (!found)
				throw new IllegalArgumentException();
		}
	}
	
	/**
	 * @param c,
	 *            Code to be used compared to
	 * @return result, array of booleans indicating match or no match
	 */
	public boolean[] compare(Code c) {
		boolean[] result = new boolean[pegNumber];
		for (int i = 0; i < pegNumber; i++)
			result[i] = pegs[i].equals(c.pegs[i]);

		return result;
	}

	@Override
	/**
	 * @param c,
	 *            Code to compare with
	 * @return result, equal or not
	 */
	public boolean equals(Object c) {
		boolean[] result;
		if (c instanceof Code)
			result = compare((Code) c);
		else
			return false;

		for (boolean b : result)
			if (!b)
				return false;

		return true;
	}

	@Override
	/**
	 * @return result, String formatted code "???..."
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (String c : pegs)
			result.append(c);

		return result.toString();
	}

	/**
	 * @return returns the private field pegs
	 */
	public String[] getPegs() {
		return pegs;
	}
}
