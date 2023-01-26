package SWEA;

import java.util.Scanner;

public class Solution_SWEA_1215 {

	public static void main(String[] args) {
//		int[] dEven = {-2, -1, 1, 2};
//		int[] dOdd = {-2, -1, 1, 2};
		
		int T = 10;
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc<=10; tc++) {
			int length = sc.nextInt();
			char[][] map = new char[8][8];
			for(int i = 0; i<8; i++) {
				for(int j = 0; j<8; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
		}
		
	}

}
