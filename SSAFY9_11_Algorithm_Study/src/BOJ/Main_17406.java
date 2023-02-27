package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17406 {

	static int N, M, R;
	static int[][] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, N - 1, 0, M - 1);

		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				bw.write(String.valueOf(A[i][j])+" ");
			}
			bw.flush();
			System.out.println();
			
		}
	}

	public static void dfs(int x1, int x2, int y1, int y2) {
		if (x1 > x2 || y1 > y2) // 양 끝 값이 역전되는 순간 종료
			return;

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

		// R번 회전을 전부 하면 불필요한 회전을 할 수도 있기에, 큐의 크기로 나눈 나머지로 회전하도록 한다.
		int r = R % queue.size();
		while (r > 0) {
			int temp = queue.pollLast(); //pollLast: LinkedList의 마지막 요소를 반환하며 제거
			queue.addFirst(temp); // 맨 뒤 값을 맨 앞으로 넣는다
			r--;
		}

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

		dfs(x1 + 1, x2 - 1, y1 + 1, y2 - 1);

	}
}
