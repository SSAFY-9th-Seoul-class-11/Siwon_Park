package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17406 {
	static int N, M, K;
	static int[][] A;
	static int[][] R;
	static int[] numbers; 
	static boolean[] isSelected;
	static int min; //배열 A의 값! 최솟값
	static int[][] save;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 회전 연산 개수

		A = new int[N][M];
		save = new int[N][M];
		
		R = new int[K][3]; // 회전 연산 배열

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = save[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbers = new int[K];//각 자리에 뽑힌 수
		isSelected = new boolean[K+1];// 인덱스: 수번호
		min = Integer.MAX_VALUE;
		permutation(0);
		
		System.out.println(min);
	}

	public static void permutation(int cnt) {// 순서 정하기

		if (cnt == K) {
			//배열 초기화
			for (int x = 0; x < N; x++) {
				for (int j = 0; j < M; j++) {
					A[x][j] = save[x][j];
				}
			}
			for(int i = 0; i<K; i++) { // 순서대로 r-s, r+s, c-s, c+s 를 한다. 행열 +1씩 받아서 -1해준다
				// 배열 입력
				rotate(R[numbers[i]][0]-R[numbers[i]][2]-1, R[numbers[i]][0]+R[numbers[i]][2]-1, R[numbers[i]][1]-R[numbers[i]][2]-1, R[numbers[i]][1]+R[numbers[i]][2]-1);
			}
			minSum();
			return;
		}
		for (int i = 0; i <K; i++) {
			// 기존수와 중복 체크
			if (isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);// 다음 수 뽑으러 가기
			isSelected[i] = false;
		}
	}

	// 배열 돌리는 함수
	public static void rotate(int x1, int x2, int y1, int y2) {
		
		if (x1 >= x2 || y1 >= y2) {// 양 끝 값이 역전되는 순간 종료
			return;
		}
			
		Deque<Integer> queue = new LinkedList<>();
		for (int i = x1; i < x2; i++) {
			queue.add(A[i][y1]);
		}
		for (int i = y1; i < y2; i++) {
			queue.add(A[x2][i]);
		}
		for (int i = x2; i > x1; i--) {
			queue.add(A[i][y2]);
		}
		for (int i = y2; i > y1; i--) {
			queue.add(A[x1][i]);
		}

		int temp = queue.poll(); //맨 앞을 빼서
		queue.add(temp); // 맨 뒤 값을 맨 뒤로 넣는다

		for (int i = x1; i < x2; i++) {
			A[i][y1] = queue.poll();
		}
		for (int i = y1; i < y2; i++) {
			A[x2][i] = queue.poll();
		}
		for (int i = x2; i > x1; i--) {
			A[i][y2] = queue.poll();
		}
		for (int i = y2; i > y1; i--) {
			A[x1][i] = queue.poll();
		}
		rotate(x1 + 1, x2 - 1, y1 + 1, y2 - 1); //안쪽 배열 돌리기

	}
	//행 더해서 비교하는 함수
	public static void minSum() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += A[i][j];
			}
			if(min>sum) min = sum;
		}
		return;
	}
}
