package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static class Pos {
		int x, y;
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int max = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		for(int depth = 0; depth<max; depth++) {
			visited = new boolean[N][N];
			int count = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(!visited[i][j] && map[i][j]>depth) {
						dfs(new Pos(i, j), depth);
						count++;
					}
				}
			}
			cnt = Math.max(cnt, count);
		}
		System.out.println(cnt);
	}
	public static void dfs(Pos p, int depth) {
		visited[p.x][p.y] = true;
		for(int i = 0; i<4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue; // 범위체크
			if(map[nx][ny]<=depth) continue; // 깊이 체크
			if(visited[nx][ny]) continue; // 방문체크
			dfs(new Pos(nx, ny), depth);
		}
	}
}
