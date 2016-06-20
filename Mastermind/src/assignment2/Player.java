package assignment2;

import java.util.Scanner;

public class Player {
	private boolean ready;
	private Scanner scan;

	public Player() {
		ready = false;
		scan = new Scanner(System.in);
	}

	public String guess() {
		String guess = scan.nextLine();
		if (guess.toLowerCase().equals("history"))
			return showHistory();
		else
			return guess;
	}
	
	public boolean startGame() {
		boolean asking = true;
		while(asking) {
			String reply = scan.next();
			if (reply.toLowerCase().equals("y"))
				return ready=true;
			else if (reply.toLowerCase().equals("n"))
				return ready=false;
			else
				System.out.println("Invalid choice. Please enter either Y/N.");
		}
		return ready;
	}
	
	public boolean playAnother() {
		if (!startGame())
			scan.close();
		return ready;
	}
	
	public String showHistory() {
		return null;
	}
}
