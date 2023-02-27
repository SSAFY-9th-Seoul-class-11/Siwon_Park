package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {
	static int[][] group;
	static int N;
	static int M;
	static int K;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열의 크기 NxM N, M 짝수라 함!!
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken()); //연산 횟수
		
		// 행열 중 큰 수로 배열 만들자
		K = Math.max(N, M); 
		group = new int[K][K];
		//배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				group[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine()); //수행해야 하는 연산..들..
		for(int i = 0; i<count; i++) {
			int num = Integer.parseInt(st.nextToken()); //연산 번호
			operation(num);
		}

		//연산 완료한 배열 출력하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(group[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void operation(int num) {

		int[][] temp = new int[K][K];
		int tmp = 0;
		switch (num) {
		case 1: // 상하 반전
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					temp[N-1-i][j] = group[i][j];
				}
			}
			break;
		case 2: // 좌우 반전
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					temp[i][M-1-j] = group[i][j];
				}
			}
			break;
		case 3: // 오른쪽 90도 회전
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					temp[j][N-1-i] = group[i][j];
				}
			}
			//행열 크기가 다르니, N, M  바꿔주기
			tmp = N;
			N = M;
			M = tmp;
			break;
		case 4: // 왼쪽 90도 회전
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					temp[M-1-j][i] = group[i][j];
				}
			}
			//행열 크기가 다르니, N, M  바꿔주기
			tmp = N;
			N = M;
			M = tmp;
			break;
		case 5: // 시계방향으로 사분면 돌리기
			// 1->2
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i][j + M / 2] = group[i][j];
				}
			}
			// 2->3
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i][j + M / 2] = group[i][j];
				}
			}
			// 3->4
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i][j - M / 2] = group[i][j];
				}
			}
			// 4->1
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i - N / 2][j] = group[i][j];
				}
			}
			//group = temp;
			break;
		case 6: //반시계방향으로 사분면 돌리기
			// 1->4
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i + N / 2][j] = group[i][j];
				}
			}
			// 4->3
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i][j + M / 2] = group[i][j];
				}
			}
			// 3->2
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i - N / 2][j] = group[i][j];
				}
			}
			// 2->1
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i][j - M / 2] = group[i][j];
				}
			}
			break;
		}
		group = temp;
	}

}
