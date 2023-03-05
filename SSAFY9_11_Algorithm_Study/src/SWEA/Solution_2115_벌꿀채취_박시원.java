package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취_박시원 {

	static int N, M, C, result;
	static int[][] honeyComb, profit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통 크기
			M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통 개수
			C = Integer.parseInt(st.nextToken()); // 최대 양

			honeyComb = new int[N][N];
			profit = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					honeyComb[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
            start();
            
            System.out.println("#" + tc + " " + result);
		}
	}

	private static void start() {
		makeProfit();
		// 일꾼 A가 채취할 구간
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				combination(i, j + M, 1, profit[i][j]);
			}
		}
	}

	//A가 채취할 구간을 먼저 정한 후 B가 채취할 구간을 조합으로 정하자
	private static void combination(int r, int c, int cnt, int sum) {
		if (cnt == 2) {
			result = Math.max(result, sum);
			return;
		}
		// 일꾼 B가 채취할 구간
		for (int i = r; i < N; i++) {
			for (int j = c; j <= N - M; j++) {
				combination(i, j, cnt + 1, sum + profit[i][j]);
			}
			c = 0;
		}
	}

	// 해당 구간에서 얻을 수 있는 최대 수익 구하기
	private static void makeProfit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				// 여기서 얻을 수 있는 최대 수익(부분집합)
				subsetProfit(i, j, 0, 0, 0);
			}
		}
	}

	//부분집합으로 최대 수익 구하기
	private static void subsetProfit(int r, int c, int cnt, int sum, int totalSum) {
        if(sum > C) return;
        if(cnt == M) {
            // 여기서 최대 수익 확인!!
            profit[r][c - M] = Math.max(profit[r][c - M], totalSum);
            return;
        }
        // 채취 하고 다음
        subsetProfit(r, c + 1, cnt + 1, sum + honeyComb[r][c], totalSum + honeyComb[r][c] * honeyComb[r][c]);
        // 채취 안하고 다음
        subsetProfit(r, c + 1, cnt + 1, sum, totalSum);   
	}
}
