package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 수열 길이
		StringTokenizer st = new StringTokenizer(br.readLine()); // 수열
		int[][] dp = new int[n+1][n+1]; // 첫번째 배열 인덱스가 시작 숫자 인덱스, 두번째가 끝 인덱스
		for(int i = 1; i<=n; i++) {
			dp[i][1] = Integer.parseInt(st.nextToken());
		}
		int max=dp[1][1];
		for(int i = 1; i<=n; i++) {
			for(int j = i+1; j<=n; j++) {
				dp[i][j] = dp[i][j-1]+dp[j][1];
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
}
