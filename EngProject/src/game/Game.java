package game;

import java.util.Random;

public class Game {

	// Board (size)
	static char[][] board = new char[10][10];
	// NUMBER OF FLIES
	static int kFlies = 5;
	// Random
	private static Random random = new Random();

	/**
	 * This function initializes the board, by filling it with empty spaces ('-')
	 * and flies
	 */
	public static void initializeBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '-'; // Empty space
			}
		}
		for (int i = 0; i < kFlies; i++) {
			int x, y;
			do {
				x = random.nextInt(board.length);
				y = random.nextInt(board[0].length);
			} while (board[x][y] == 'F'); // Avoid duplicating flies
			board[x][y] = 'F'; // Place a fly
		}
	}

	/**
	 * This function prints the board
	 */
	public static void showBoard() {
		System.out.println();
		for (char[] row : board) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * 
	 * @param playerRow La fila de las coordenadas seleccionadas por el jugador
	 * @param playerCol La columna de las coordenadas seleccionadas por el jugador
	 */
	public static void moveFlies(int playerRow, int playerCol) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// Finds all flys during the loop and check if any of them is next to the player
				// selection
				if (board[i][j] == 'F' && isNextTo(playerRow, playerCol, i, j)) {
					board[i][j] = '-'; // Fly flutters away
					int newX, newY;
					// Selects a random empty tile for the new position of the fly
					do {
						newX = random.nextInt(board.length);
						newY = random.nextInt(board[0].length);
					} while (board[newX][newY] != '-'); // Find an empty cell
					board[newX][newY] = 'F';
				}
			}
		}
	}

	/**
	 * This function controls if the flies have to move or not
	 * 
	 * @param r1 Row 1 (Player)
	 * @param c1 Column 1 (Player)
	 * @param r2 Row 2 (Fly)
	 * @param c2 Column 2 (Fly)
	 * @return true if there's a fly (r2,c2) next to the position (r1,c1) selected
	 */
	private static boolean isNextTo(int r1, int c1, int r2, int c2) {
		// Checks the rows and columns between the player selection and the fly postion
		// to check if they are nextot o each other
		return Math.abs(r1 - r2) <= 1 && Math.abs(c1 - c2) <= 1;
	}
}
