package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이_박시원 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 0, -1, 1, -2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, 0, 0, -1, 1, -2, 2, -2, 2, -1, 1};
	
	static class Pos{
		int x, y, cnt, hCnt;//좌표, 전체 이동 수, 말 이동 수
		Pos(int x, int y, int cnt, int hCnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.hCnt = hCnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(move(0, 0));
		
	}
	static int move(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.x == H-1 && p.y == W-1) { //도착지점 도착시 이동횟수 return
				return p.cnt;
			}
			//일반move
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;//범위 체크
				if(visited[nx][ny][p.hCnt]) continue;//방문체크
				
				if(map[nx][ny] == 0) {//장애물 없을 때만 이동
					visited[nx][ny][p.hCnt] = true;
					q.add(new Pos(nx, ny, p.cnt + 1, p.hCnt));
				}
			}
			//말move
			if(p.hCnt < K) {//이동횟수 남았을 때만
				for(int i=4; i<12; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;//범위 체크
					if(visited[nx][ny][p.hCnt + 1]) continue;//방문체크
					
					if(map[nx][ny] == 0) {//장애물 없을 때만 이동
						visited[nx][ny][p.hCnt + 1] = true;
						q.add(new Pos(nx, ny, p.cnt + 1, p.hCnt + 1));
					}
				}
			}	
		}
		return -1;
	}
}
