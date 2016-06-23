# Mastermind

The Driver class contains the main method to be executed.

GameConfiguration contains the preset 3 fields to be chosen, *in addition to* a manually inputted string specifying the full name of the colors to be allowed (for printing instructions' sake).

The Game class contains and manipulates all instances and methods of other classes (Player, Code, Computer, Message).
The runGame(int count) method contained within Game recursively creates new Game objects as many times as the user specifies to play again.
(The argument is the # game the user is currently about to play.)

The Player class handles user input.

The Code class handles peg sequences in the game including methods for comparison between Codes.

The Computer class generates feedback for a guess, and it generates the secret code at the start of a Game.

The Message class stores and formats strings to output to the user. It is never instantiated, but instead only its static fields and methods are used (by the Game object).
