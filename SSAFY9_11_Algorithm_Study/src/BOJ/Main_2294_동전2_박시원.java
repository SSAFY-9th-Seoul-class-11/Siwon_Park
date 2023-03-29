package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2294_동전2_박시원 {

	static int n, k; //n가지 종류 동전, 가치 합 k
	static int[] coin, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n+1];
		dp = new int[k+1]; //가치합에서의 최소 동전 개수
		for(int i = 1; i<=n; i++) {
			coin[i] = Integer.parseInt(br.readLine());	
		}
		for(int i = 1; i<=k ; i++) {
			dp[i] = 1000001;
		}
		dp[0] = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = coin[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j-coin[i]]+1, dp[j]);
			}
		}
		if(dp[k] == 1000001) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}
