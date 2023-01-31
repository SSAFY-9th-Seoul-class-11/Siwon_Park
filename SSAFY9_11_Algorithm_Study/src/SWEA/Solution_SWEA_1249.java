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
	public static int min;//복구 작업 시간 최소 값
	public static int[][] map;//맵
	public static int[][] time;//맵의 좌표까지 걸린 시간
	public static boolean[][] visited;//방문 체크
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;//최소 값을 가장 큰 값으로 초기화
			
			//N값
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			time = new int[N][N];
			visited = new boolean[N][N];
			
			//맵 입력받기
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			dfs(0, 0);
			
			System.out.println("#" + (tc) + " "+min);
		} 
	}
	
	public static void dfs(int x, int y) {
		if(x == N-1 && y == N-1) {
			min = Math.min(min, time[N-1][N-1]);
			return;
		}
		
		
		if(time[y][x]>=min) return;
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			
			if(visited[ny][nx] == false || time[ny][nx]>time[y][x]+map[ny][nx]) {
				time[ny][nx] = time[y][x]+map[ny][nx];
				visited[ny][nx] = true;
				dfs(nx, ny);
				
			}
//			for(int j = 0; j<N; j++) {
//				for(int k = 0; k<N; k++) {
//					System.out.print(time[j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("----------");
		}
		
	}
	

}
