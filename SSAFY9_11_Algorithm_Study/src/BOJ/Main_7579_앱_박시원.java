package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579_앱_박시원 {
	static int N, M;
	static int[] m, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int result = Integer.MAX_VALUE;

		m = new int[N];
		c = new int[N];
		int[][] dp = new int[N][100001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int cost = c[i];
			int memory = m[i];

			for (int j = 0; j <= 10000; j++) {
				if (i == 0) {
					if (j >= cost)
						dp[i][j] = memory;
				} else {
					if (j >= cost) {
						dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
					}
					else {
						dp[i][j] = dp[i - 1][j];
					}
				}
				if (dp[i][j] >= M) result = Math.min(result, j);
			}
		}
		System.out.println(result);
	}
}
