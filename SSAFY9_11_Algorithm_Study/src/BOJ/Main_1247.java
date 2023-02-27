package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1247 {
	static int N, min;
	static boolean[] visited; // 방문 체크
	static int[] order; // 방문 순서 저장
	static int[][] map; // 좌표

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 고객수
			min = Integer.MAX_VALUE;
			visited = new boolean[N + 2];
			order = new int[N + 2];
			map = new int[N + 2][2]; // 좌표 저장할 배열
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 회사 좌표
			map[0][0] = Integer.parseInt(st.nextToken());
			map[0][1] = Integer.parseInt(st.nextToken());
			// 집 좌표
			map[N + 1][0] = Integer.parseInt(st.nextToken());
			map[N + 1][1] = Integer.parseInt(st.nextToken());
			// 고객 좌표
			for (int i = 1; i <= N; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			find(1);
			System.out.println("#" + tc + " " + min);
		}
	}

	public static void find(int num) {
		if (num == N + 1) {// 끝까지 왔으면!
			int sum = 0;
			// 거리 계산
			for (int i = 0; i <= N; i++) {
				sum += Math.abs(map[order[i]][0] - map[order[i + 1]][0])
						+ Math.abs(map[order[i]][1] - map[order[i + 1]][1]);
			}
			if (sum < min)
				min = sum; // 최단 거리 찾기
			return;
		}
		// 회사
		order[0] = 0; // 거리 순서에 저장
		visited[0] = true; // 방문 체크
		// 집
		order[N + 1] = N + 1; // 거리 순서에 저장
		visited[N + 1] = true; // 방문 체크
		// 고객
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;
			order[num] = i;
			visited[i] = true;
			find(num + 1);
			visited[i] = false;
		}
	}

}
