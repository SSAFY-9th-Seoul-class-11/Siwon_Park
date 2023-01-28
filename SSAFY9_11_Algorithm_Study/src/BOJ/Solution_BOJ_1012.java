package BOJ;

import java.util.Scanner;

public class Solution_BOJ_1012 {

	public static int[][] field = new int[50][50];//배추밭
	
	public static int N, M;//세로, 가로 길이
		
	//상하좌우
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			M = sc.nextInt();//가로길이, 열 수 
			N = sc.nextInt();//세로길이, 행 수
			int K = sc.nextInt();//배추 개수

			//배추 심기
			for(int b = 0; b<K; b++) {
				int X = sc.nextInt();//M, 열
				int Y = sc.nextInt();//N, 행
				field[Y][X] = 1; //입력받은 곳에 배추 심기
				
				//입력 못받은데 0 입력
				for(int i = 0; i<N; i++) {
					for(int j = 0; j<M; j++) {
						if(field[i][j] != 1) {
							field[i][j] = 0;
						}
					}
				}
			}
			
			int count = 0;//배추흰지렁이 마리 수
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(DFS(i, j)) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static boolean DFS(int x, int y) {
		//범위 벗어난다면 false
		if(x<0 || x>=N || y<0 || y>=M) {
			return false;
		}
		//배추 심겨있다면
		if(field[x][y] == 1) {
			field[x][y] = 0;//방문 처리
			//상하좌우 재귀로 호출
			for(int i = 0; i<4; i++) {
				DFS(x+dx[i], y+dy[i]);
			}
			return true;
		}
		return false;
	}
}
