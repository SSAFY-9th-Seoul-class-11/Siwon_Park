package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	// ↘, →, ↓
	static int[] dx = {1, 0, 1};
	static int[] dy = {1, 1, 0}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		move(0, 1, 1);
		System.out.println(cnt);
	}
	
	public static void move(int x, int y, int mod) {
		if(x == N-1 && y ==N-1) {
			cnt += 1;
			return;
		}
		for(int i = 0; i<3; i++) {
			if(x+dx[i]>=N || y+dy[i]>=N) continue; //범위 체크
			// 대각선을 갈 때 추가 체크
			if(i == 0) {
				if(map[x][y+1] == 1 || map[x+1][y] == 1) continue; 
			}
			if(mod == 1 && i == 2) continue;//오른쪽일 때 아래로 못감
			if(mod == 2 && i == 1) continue;//아래일 때 오른쪽으로 못감
			if(map[x+dx[i]][y+dy[i]] == 0) {
				if(visited[x+dx[i]][y+dy[i]]) continue; //방문 체크
				visited[x+dx[i]][y+dy[i]] = true;
				move(x+dx[i], y+dy[i], i);
				visited[x+dx[i]][y+dy[i]] = false;
			}
		}
	}
}
