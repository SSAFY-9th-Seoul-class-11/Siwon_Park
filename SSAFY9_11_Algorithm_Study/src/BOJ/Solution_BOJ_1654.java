package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수 K
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 N
		long result = 0; // N개를 만들 수 있는 랜선의 최대 길이
		long max = 0; // 최대값	
		long[] lanline = new long[K]; // K개의 랜선 길이 담을 배열
		for (int i = 0; i < K; i++) {
			lanline[i] = Integer.parseInt(br.readLine()); // 랜선 길이 입력
			max = Math.max(max, lanline[i]); // 최대값 찾기
		}
		long min = 1; // 최솟값은 1

		// 이진 탐색 수행(반복적)
		while (min <= max) {
			long mid = (min + max) / 2;
			long count = 0; // 랜선 수

			for (long lan : lanline) {
				count += lan / mid; // 랜선을 중간 값으로 자른 수 세기
			}

			if (count < N) { // 원하는 랜선 개수 보다 잘라진 랜선 수가 적을 경우, 랜선 길이를 더 짧게 만들어야 함(왼쪽 부분 탐색)
				max = mid - 1;
			} else { // 원하는 랜선 개수 보다 잘라진 랜선 수가 많을 경우, 랜선 길이를 더 길게 만들어야 함(오른쪽 부분 탐색)
				result = mid; // 랜선의 길이가 최대일 때가 정답이므로, 여기에서 result를 기록
				min = mid + 1;
			}
		}
		System.out.println(result);
	}
}
