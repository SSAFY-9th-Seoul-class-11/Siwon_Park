package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_박시원 {
	static int N, M, max;
	static int[][] map, copyMap, spreadMap;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	static class Virus{
		int x, y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = copyMap = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = copyMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(copyMap, 0);
		System.out.println(max);
	}
	
	public static void makeWall(int[][] copyMap, int cnt) {
		if(cnt == 3) {
			spreadVirus();
			return;
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(copyMap[i][j] == 0) copyMap[i][j] = 1;
				makeWall(copyMap, cnt+1);
				copyMap[i][j] = 0;
			}
		}
	}
	public static void spreadVirus() {
		spreadMap = new int[N][M];
		spreadMap = copyMap;
		for(int i = 0; i<N; i++) {
			System.arraycopy(copyMap[i], 0, spreadMap[i], 0, M);
		}
		Queue<Virus> q = new LinkedList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(spreadMap[i][j] == 2) {
					q.add(new Virus(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			Virus v = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(spreadMap[nx][ny] != 0) continue;
				spreadMap[nx][ny] = 2;
				q.add(new Virus(nx, ny));
			}
		}
		cntVirus(spreadMap);
	}
	
	public static void cntVirus(int[][] map) {
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		max = Math.max(cnt, max);
	}

}
