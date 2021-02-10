package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	static Scanner in;
	static String[] board;
	static String turn;
	static int player;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[9];
		String winner = null;
		populateEmptyBoard();

		int player = Toss();
		//player checked 1-user, 0-computer
		if(player == 1)
		{
			System.out.println("User plays first.");
			chooseLetter();
		}
		else
		{
			System.out.println("Computer plays first.");
			chooseLetter();
		}
		printBoard();
		
		//computer play as a user 
		
		while (winner == null)
		{
			int numInput;
			try
			{
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9))
				{
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			if (board[numInput-1].equals(String.valueOf(numInput)))
			{
				board[numInput-1] = turn;
				if (turn.equals("X"))
				{
					turn = "O";
				}
				else
				{
					turn = "X";
				}
				printBoard();
				winner = checkWinner();
			}
			else
			{
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw"))
		{
			System.out.println("It's a draw! Thanks for playing.");
		}
		else
		{
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}

	//This function is used to reset the board
	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}

	
	// random player  random output to check which player plays first
	  
	public static int Toss() {
		System.out.println("Toss to see who plays first!");
		Random random = new Random();
		return random.nextInt(2);
	}

	
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

	//This function displays the board to let player choose the seed
	public static void printBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");
	}

	
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
	
	public static void nextMove() {
		for(int a = 0; a < 6; a++)
		{
			//Checks for all seeds in row
			String line1 = board[0] + board[1] + board[2];
			String line2 = board[3] + board[4] + board[5];
			String line3 = board[6] + board[7] + board[8];
			//Checks for all seeds in column
			String line4 = board[0] + board[3] + board[6];
			String line5 = board[1] + board[4] + board[7];
			String line6 = board[2] + board[5] + board[8];
			//Check for all seeds in diagonal
			String line7 = board[0] + board[4] + board[8];
			String line8 = board[2] + board[4] + board[6];
			
			switch(a)
			{
				case 0 :
					{
						if(line1.equals("1XX"))
							System.out.println("Enter value: 1");
						else if(line2.equals("4XX"))
							System.out.println("Enter value: 4");
						else if(line3.equals("7XX"))
							System.out.println("Enter value: 7");
						break;
					}
				case 1 :
					{
						if(line1.equals("X2X"))
							System.out.println("Enter value: 2");
						else if(line2.equals("X5X"))
							System.out.println("Enter value: 5");
						else if(line3.equals("X8X"))
							System.out.println("Enter value: 8");
						break;
					}
				case 2 :
					{
						if(line1.equals("XX3"))
							System.out.println("Enter value: 3");
						else if(line2.equals("XX6"))
							System.out.println("Enter value: 6");
						else if(line3.equals("XX9"))
							System.out.println("Enter value: 9");
						break;
					}
				case 3 :
					{
						if(line4.equals("1XX"))
							System.out.println("Enter value: 1");
						else if(line5.equals("2XX"))
							System.out.println("Enter value: 2");
						else if(line6.equals("3XX"))
							System.out.println("Enter value: 3");
						break;
					}
				case 4 :
					{
						if(line4.equals("X4X"))
							System.out.println("Enter value: 4");
						else if(line5.equals("X5X"))
							System.out.println("Enter value: 5");
						else if(line6.equals("X6X"))
							System.out.println("Enter value: 6");
						break;
					}
				case 5 :
					{
						if(line4.equals("XX7"))
							System.out.println("Enter value: 7");
						else if(line5.equals("XX8"))
							System.out.println("Enter value: 8");
						else if(line6.equals("XX9"))
							System.out.println("Enter value: 9");
						break;
					}
				case 6 :
					{
						if(line7.equals("1XX"))
							System.out.println("Enter value: 1");
						else if(line7.equals("XX9"))
							System.out.println("Enter value: 9");
						break;
					}
				case 7 :
					{
						if(line8.equals("3XX"))
							System.out.println("Enter value: 3");
						else if(line8.equals("XX7"))
							System.out.println("Enter value: 7");
						break;
					}
				case 8 :
					{
						if(line7.equals("X5X"))
							System.out.println("Enter value: 5");
						else if(line8.equals("X5X"))
							System.out.println("Enter value: 5");
						break;
					}					
			}
		}
	}
}