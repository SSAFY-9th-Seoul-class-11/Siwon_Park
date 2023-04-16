package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠_박시원 {
	static int[][] sudoku = new int[9][9];
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<9; i++) {
			String str = br.readLine();
			for(int j = 0; j<9; j++) {
				sudoku[i][j] = str.charAt(j)-'0';
			}
		}
		
		game(0, 0);
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}

	}
	
	public static void game(int x, int y) {
		// 열돌고 행돌기
		if(y == 9 ) { //열 끝까지 오면 행++
			x++;
			y = 0;
		}
		if(x == 9 ) {
			flag = true;
			return;
		}
		if(sudoku[x][y] != 0) { //값이 있으면 다음칸 ㄱㄱ
			game(x, y+1);
		}else {
			for(int i = 1; i<=9; i++) { // 1부터 넣을 수 있는지 확인하자
				if(!check(x, y, i)) continue; //안되면 이 값은 넘어가자
				sudoku[x][y] = i;
				game(x, y+1);
				if(flag) return; //이미 끝까지 간게 있으면 return
				sudoku[x][y] = 0;
			}
		}
	}
	
	public static boolean check(int x, int y, int idx) {
		//행에 idx가 있는지
		for(int i = 0; i<9; i++) {
			if(sudoku[x][i] == idx) return false;
		}
		//열에 idx가 있는지
		for(int i = 0; i<9; i++) {
			if(sudoku[i][y] == idx) return false;
		}
		//네모에 idx가 있는지 //가장 왼쪽 위에 있는 칸 인덱스: 해당 숫자 - 해당 숫자를 3으로 나눈 나머지
		for(int i = x-x%3; i<x-x%3+3; i++) {
			for(int j = y-y%3; j<y-y%3+3; j++) {
				if(sudoku[i][j] == idx) return false;
			}
		}
		return true;
	}
}
