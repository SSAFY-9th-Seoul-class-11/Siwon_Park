package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS_박시원 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;

	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
			
		}
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];

		bfs(V);

		System.out.println(sb);
	}
	//dfs
	public static void dfs(int start) {

		visited[start] = true;
		sb.append(start + " ");

		for (int i = 0; i <= N; i++) {
			if (arr[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}
	//bfs
	public static void bfs(int start) {
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {

			start = q.poll();
			sb.append(start + " ");

			for (int i = 1; i <= N; i++) {
				if (arr[start][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}

	}

}
