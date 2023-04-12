package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스토쿠_박시원 {
	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<9; i++) {
			String str = br.readLine();
			for(int j = 0; j<9; j++) {
				sudoku[i][j] = str.charAt(j)-'0';
			}
		}
		
		game();
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}

	}
	
	public static void game() {
		
	}

}
