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
		int[] num = new int[n+1];
		int[] dp = new int[n+1]; // 인덱스까지 왔을 때 최대값
		for(int i = 1; i<=n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = num[1];
		int max = num[1];
		for(int i = 2; i<=n; i++) {
			dp[i] = Math.max(dp[i-1]+num[i], num[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
