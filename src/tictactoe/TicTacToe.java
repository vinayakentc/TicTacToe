package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	static String[] board;
	static String turn;


	public static void main(String[] args) {
		board = new String[9];
		populateEmptyBoard();
	}

	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
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
	
	//This method displays the board 
		public static void printBoard() {
			System.out.println("/---|---|---\\");
			System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
			System.out.println("/---|---|---\\");
		}
}