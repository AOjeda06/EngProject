package game;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static char[][] tablero = new char[10][10];
	static int kFlies = 5; // Adjust the number of flies
	static Random random = new Random();

	public static void main(String[] args) {
		inicializarTablero();
		jugar();
	}

	private static void inicializarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = '-'; // Empty space
			}
		}
		for (int i = 0; i < kFlies; i++) {
			int x, y;
			do {
				x = random.nextInt(tablero.length);
				y = random.nextInt(tablero[0].length);
			} while (tablero[x][y] == 'F'); // Avoid duplicating flies
			tablero[x][y] = 'F'; // Place a fly
		}
	}

	private static void mostrarTablero() {
		for (char[] row : tablero) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}

	private static void jugar() {
		Scanner scanner = new Scanner(System.in);
		int fliesCaught = 0;

		while (fliesCaught < kFlies) {
			System.out.println("Enter your guess (row and column): ");
			int row = scanner.nextInt();
			int col = scanner.nextInt();

			if (tablero[row][col] == 'F') {
				System.out.println("You caught a fly!");
				tablero[row][col] = '-';
				fliesCaught++;
			} else {
				System.out.println("Miss! Flies might have moved...");
				moverMoscas(row, col);
			}

			mostrarTablero();
		}

		System.out.println("Congratulations! You caught all the flies!");
		scanner.close();
	}

	private static void moverMoscas(int playerRow, int playerCol) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == 'F' && isNextTo(playerRow, playerCol, i, j)) {
					tablero[i][j] = '-'; // Fly flutters away
					int newX, newY;
					do {
						newX = random.nextInt(tablero.length);
						newY = random.nextInt(tablero[0].length);
					} while (tablero[newX][newY] != '-'); // Find an empty cell
					tablero[newX][newY] = 'F';
				}
			}
		}
	}

	private static boolean isNextTo(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) <= 1 && Math.abs(c1 - c2) <= 1;
	}
}
