package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기_박시원 {

	static int[][] map = new int[10][10];
	static int[] cp = new int[6];
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 1; i <= 5; i++) {
			cp[i] = 5;
		}
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		if(minCnt == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minCnt);
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(x>9) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		if(y>9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		if(map[x][y] == 1) {
			for(int i = 5; i>0; i--) {
				if(cp[i]>0 && possible(x, y, i)) {
					attach(x, y, i);
					cnt++;
					dfs(x, y+1, cnt);
					detach(x, y, i);
					cnt--;
				}
			}
		}else {
			dfs(x, y+1, cnt);
		}
	}

	public static void attach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = 0;
			}
		}
		cp[size]--;
	}

	public static void detach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = 1;
			}
		}
		cp[size]++;
	}
	
	public static boolean possible(int x, int y, int size) {

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i<0 || i>9 || j<0 || j>9 || map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
