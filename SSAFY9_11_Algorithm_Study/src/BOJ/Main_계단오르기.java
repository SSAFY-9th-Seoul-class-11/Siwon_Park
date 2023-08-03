package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 계단 수
		int[] stairs = new int[n+1];
		int[][] dp = new int[n+1][2]; // 열 인덱스 0: 계단 안밟음, 1: 계단 밟음
		for(int i = 1; i<=n; i++) {
			stairs[i] = Integer.parseInt(br.readLine()); 
		}
		dp[1][1] = stairs[1];

		for(int i = 2; i<=n; i++) {
			dp[i][0] = dp[i-1][1]; // i번째 계단을 밟지 않았을 때 최대값 == i-1번째 계단을 밟았을 때 최대값
			dp[i][1] = Math.max(dp[i-2][1]+stairs[i], dp[i-2][0]+stairs[i-1]+stairs[i]);
		}
		System.out.println(dp[n][1]);
	}

}
