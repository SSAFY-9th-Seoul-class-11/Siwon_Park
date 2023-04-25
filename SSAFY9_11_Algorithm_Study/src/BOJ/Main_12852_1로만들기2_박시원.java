package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12852_1로만들기2_박시원 {

	static class Value {
		int n;
		String process;

		Value(int n, String process) {
			this.n = n;
			this.process = process;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Value[] dp = new Value[N + 1];
		dp[1] = new Value(0, "1");

		for (int i = 2; i <= N; i++) {
			int cnt = Integer.MAX_VALUE;
			int before = 0;
			if (i % 3 == 0) {
				cnt = dp[i / 3].n;
				before = i / 3;
			}

			if (i % 2 == 0) {
				if (cnt > dp[i / 2].n) {
					cnt = dp[i / 2].n;
					before = i / 2;
				}
			}

			if (cnt > dp[i - 1].n) {
				before = i - 1;
			}

			dp[i] = new Value(dp[before].n + 1, i + " " + dp[before].process);
		}
		System.out.println(dp[N].n + "\n" + dp[N].process);
	}
}
