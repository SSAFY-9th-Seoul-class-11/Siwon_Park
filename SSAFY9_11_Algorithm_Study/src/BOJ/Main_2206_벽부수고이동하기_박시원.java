package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기_박시원 {
	static class Pos{ // 위치, 이동 횟수, 벽 부쉈는지 여부
		int x, y, cnt;
		boolean broken;
		public Pos(int x, int y, int cnt, boolean broken) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.broken = broken;
		}
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][][] visited; //방문 체크, 벽을 안부쉈을 때[][][0], 부쉈을 때[][][1] 두개 필요함
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1][2];
		
		for(int i = 1; i<=N; i++) {
			String str = br.readLine();
			for(int j = 1; j<=M; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		}

		bfs(new Pos(1, 1, 1, false));
		
	}
	
	public static void bfs(Pos p) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(p);
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			if(p.x == N && p.y ==M) {
				System.out.println(p.cnt);
				return;
			}
			for(int i = 0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx<=0 || nx>N || ny<=0 || ny>M) continue; // 범위 체크
				
				if(map[nx][ny] == 0) { // 벽이 없을 때
					if(!p.broken && !visited[nx][ny][0]) { // 벽을 부수지 않았고 방문no
						queue.add(new Pos(nx, ny, p.cnt+1, false));
						visited[nx][ny][0] = true;
					}else if(p.broken && !visited[nx][ny][1]) { //이미 벽을 부쉈고 방문 no
						queue.add(new Pos(nx, ny, p.cnt+1, true));
						visited[nx][ny][1] = true;
					}
				}else if(map[nx][ny] == 1) { // 벽이 있을 때 
					if(!p.broken) { //벽을 부수지 않았을 때만 가능
						queue.add(new Pos(nx, ny, p.cnt+1, true));
						visited[nx][ny][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
