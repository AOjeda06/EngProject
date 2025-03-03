package game;

public class Main {

	static char tablero[][] = new char[10][10];
	static int n;
	static int m;

	public static void main(String[] args) {
		inicializarTablero();
	}

	private static void inicializarTablero() {
		int numColumnas = 1;
		for (int i = 0 ; i < n ; i++) {
			System.out.print((int)(numColumnas+i) + "\t");
		}
		
		for (int i = 0 ; i < n ; i++) {
			for (int j  = 0 ; i < m ; i++) {
				System.out.print(" ");
			}
		}
		
	}
}
