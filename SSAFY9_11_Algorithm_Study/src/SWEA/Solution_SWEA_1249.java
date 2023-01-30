package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_SWEA_1249 {

	//상하좌우 탐색
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static int N;
	public static int min;
	public static int[][] map = new int[100][100];
	public static boolean[][] visited = new boolean[100][100];
	

	public static void main(String[] args) throws IOException {
//		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;//최소 값을 가장 큰 값으로 초기화
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			dfs(0, 0);
			
			System.out.println("#" + (tc+1) + " "+min);
		} // tc end
	}
	
	public static void dfs(int x, int y) {
		
		
	}
	

}
