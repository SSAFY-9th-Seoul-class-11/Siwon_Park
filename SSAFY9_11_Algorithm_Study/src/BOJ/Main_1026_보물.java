package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1026_보물 {
	static int N, min = Integer.MAX_VALUE;
	static int[] A, B, selected;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];	B = new int[N]; selected = new int[N]; visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(min);
	}
	public static void dfs(int cnt) {
		if(cnt == N) {
			min = Math.min(min, sum());
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = A[i];
			dfs(cnt+1);
			visited[i] = false;
		}
	}
	public static int sum() {
		int sum = 0;
		for(int i = 0; i<N; i++) {
			sum += selected[i]*B[i];
		}
		return sum;
	}
}
