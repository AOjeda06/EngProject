package game;

import java.util.Scanner;

public class Main {

	// Main for board initialize and game execution
	public static void main(String[] args) {
		// We call the method to initialize the board
		Game.initializeBoard();
		// Set the scanner
		Scanner scanner = new Scanner(System.in);
		// Counter for flies caught
		int fliesCaught = 0;

		// Loop that controls that the game continues while there are still flies to
		// catch
		while (fliesCaught < Game.kFlies) {
			System.out.println("Enter your guess (row and column): ");
			int row = scanner.nextInt();
			int col = scanner.nextInt();

			if (Game.board[row][col] == 'F') {
				System.out.println("You caught a fly!");
				Game.board[row][col] = '-';
				fliesCaught++;
				System.out.println("But maybe Flies have moved...");
				Game.moveFlies(row, col);
			} else {
				System.out.println();
				System.out.println("Miss! Flies might have moved...");
				Game.moveFlies(row, col);
			}

			Game.showBoard();
		}

		System.out.println("Congratulations! You caught all the flies!");
		scanner.close();
	}

}
