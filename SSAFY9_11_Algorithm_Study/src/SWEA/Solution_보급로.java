package SWEA;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_보급로 {
	static int N, map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j = 0; j<N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			System.out.println("#" + tc + " " +dijkstra());
		}
	}
	private static int dijkstra() {
		final int INF = Integer.MAX_VALUE;
		int[][] minTime = new int[N][N]; //출발 정점에서 자신가지 이르는 최소 복구 시간
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		}); // r, c, 출발지에서 자신까지의 최소비용
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		minTime[0][0] = 0;
		pq.offer(new int[] {0, 0, minTime[0][0]});
		
		int[] cur = null;
		int r, c, minCost;
		while(true) {
			//step1
			cur = pq.poll();
			r = cur[0];
			c = cur[1];
			minCost = cur[2];
			
			if(visited[r][c]) continue; //큐에 남아있는 잔재
			visited[r][c] = true;
			if(r == N-1 && c == N-1) return minCost; //도착지에 오면 끝내기
			
			//step2
			int nr = 0, nc = 0;
			for(int d = 0; d<4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]
						&& minTime[nr][nc]>minCost+map[nr][nc]) {
					minTime[nr][nc] = minCost+map[nr][nc];
					pq.offer(new int[] {nr, nc, minTime[nr][nc]});
				}
			}
		}	
	}
}
