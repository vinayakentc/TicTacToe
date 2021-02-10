package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	static String[] board;
	static String turn;


	public static void main(String[] args) {
		board = new String[9];
		populateEmptyBoard();
		int player = Toss();
		//player checked 1-user, 0-computer
		if(player == 1)
		{
			System.out.println("User plays first.");
		}
		if(player == 0)
		{
			System.out.println("Computer plays first.");
		}
	}

	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
	
	public static int Toss() {
		System.out.println("Toss to see who plays first!");
		Random random = new Random();
		return random.nextInt(2);
	}
	
	// player to choose letter X or O
	public static String chooseLetter() {
		System.out.println("Choose either X or O: ");
		Scanner letter = new Scanner(System.in);
		String inputLetter = letter.next();
		if(inputLetter.equals("X"))
		{
			turn = "X";
		}
		else
		{
			turn = "O";
		}
		return turn;
	}
	
	// method to displays the board 
		public static void printBoard() {
			System.out.println("/---|---|---\\");
			System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
			System.out.println("/---|---|---\\");
		}
		
		
		//make a move to a desired location in the board
		//check for free space before making desired move
		public static String checkWinner() {
			for (int a = 0; a < 8; a++)
			{
				String line = null;
				switch (a)
				{
					case 0:
						line = board[0] + board[1] + board[2];
						break;
					case 1:
						line = board[3] + board[4] + board[5];
						break;
					case 2:
						line = board[6] + board[7] + board[8];
						break;
					case 3:
						line = board[0] + board[3] + board[6];
						break;
					case 4:
						line = board[1] + board[4] + board[7];
						break;
					case 5:
						line = board[2] + board[5] + board[8];
						break;
					case 6:
						line = board[0] + board[4] + board[8];
						break;
					case 7:
						line = board[2] + board[4] + board[6];
						break;
				}
				if (line.equals("XXX"))
				{
					return "X";
				}
				else if (line.equals("OOO"))
				{
					return "O";
				}
			}

			for (int a = 0; a < 9; a++)
			{
				if (Arrays.asList(board).contains(String.valueOf(a+1)))
				{
					break;
				}
				else if (a == 8)
					return "draw";
			}

			System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
			return null;
		}
}