package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출_박시원 {

	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static char[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visited;
	static boolean[][] wvisited;
	static Queue<Pos> q = new LinkedList<>();
	static Queue<Pos> wq = new LinkedList<>();
	static int R, C, time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		wvisited = new boolean[R][C];
		// 빈 곳: . / 물: * / 돌: X / 굴: D
		for(int i = 0; i<R; i++) {
			String str = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		bfs();
		System.out.println(time);
	}
	
	public static void bfs() {
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] == '*' && !wvisited[i][j]) wq.add(new Pos(i, j));
				if(map[i][j] == 'S' && !visited[i][j]) q.add(new Pos(i, j));
			}
		}
		
		while(true) {
			time++;
			int size = wq.size();
			for(int k = 0; k<size; k++) {
				Pos wp = wq.poll();
				
				for(int i = 0; i<4; i++) {
					int nx = wp.x + dx[i];
					int ny = wp.y + dy[i];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny] == 'D' || map[nx][ny] == 'X' || wvisited[nx][ny]) continue;
					
					wq.add(new Pos(nx, ny));
					wvisited[nx][ny] = true;
					map[nx][ny] = '*';
				}
			}
			if(q.isEmpty()) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			
			size = q.size();
			for(int k = 0; k<size; k++) {
				Pos p = q.poll();
				
				for(int i = 0; i<4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny] == '*' || map[nx][ny] == 'X' || visited[nx][ny]) continue;
					if(map[nx][ny] == 'D') return;
					
					q.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
}
