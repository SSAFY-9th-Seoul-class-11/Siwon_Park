package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int[][] map;
	static int M, N, K;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for(int i = 0; i<K ; i++) {
			st = new StringTokenizer(br.readLine());
			makeMap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int idx = 0;
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]!=0) continue;
				map[i][j] = ++idx;
				dfs(i, j, idx);
			}
		}
		int[] ans = new int[idx+1];
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 1; k<=idx; k++) {
					if(map[i][j]==k) {
						ans[k]++;
						break;
					}
				}
			}
		}
		System.out.println(idx);
		Arrays.sort(ans);
		for(int i = 1; i<=idx; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
	public static void dfs(int x, int y, int idx) {
		int nx, ny;
		for(int i = 0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx<0 || nx>=M || ny <0 || ny>=N) continue; // 범위 체크
			if(map[nx][ny]!=0) continue; // 사각형, 이미 지나간 영역 체크
			map[nx][ny] = idx;
			dfs(nx, ny, idx);
		}
	}
	
	public static void makeMap(int x1, int y1, int x2, int y2) {
		for(int i = x1; i<x2; i++) {
			for(int j = y1; j<y2; j++) {
				map[j][i] = -1;
			}
		}
	}
}
