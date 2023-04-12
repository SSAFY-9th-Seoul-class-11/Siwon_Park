package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠_박시원 {
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
	
	public static boolean checkOne(int x, int y) {
		//행에 혼자 있는지
		for(int i = 0; i<9; i++) {
			if(sudoku[x][i] != sudoku[x][y]) return false;
		}
		//열에 혼자 있는지
		for(int i = 0; i<9; i++) {
			if(sudoku[i][y] != sudoku[x][y]) return false;
		}
		//네모에 혼자 있는지 //가장 왼쪽 위에 있는 칸 인덱스: 해당 숫자 3으로 나눈 몫
		for(int i = x/3; i<x/3+3; i++) {
			for(int j = y/3; j<y/3+3; j++) {
				if(sudoku[i][j] != sudoku[x][y]) return false;
			}
			
		}
		return true;
	}

}
