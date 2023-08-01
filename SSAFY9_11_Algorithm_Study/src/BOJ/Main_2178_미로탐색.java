package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static class Pos {
		int x, y;
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		String str;
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs(new Pos(0, 0));
		System.out.println(map[N-1][M-1]);
	}
	
	public static void bfs(Pos p) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(p);
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			int nx, ny;
			for(int i = 0; i<4; i++) {
				nx = pos.x + dx[i];
				ny = pos.y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue; // 범위체크
				if(map[nx][ny]==0) continue; // 벽체크
				
				if(map[nx][ny]==1) { // 방문하지 않았다면
					map[nx][ny] = map[pos.x][pos.y] + 1; // 방문체크 + 칸 수 갱신
					queue.add(new Pos(nx, ny));
				}
			}
		}
	}
}
