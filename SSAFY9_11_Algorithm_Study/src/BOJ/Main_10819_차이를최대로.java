package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
	static int N, result = Integer.MIN_VALUE;
	static int[] arr, selected;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; selected = new int[N]; visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(result);
	}
	public static void dfs(int cnt) {
		if(cnt == N) {
			result = Math.max(sum(), result);
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = arr[i];
			dfs(cnt+1);
			visited[i] = false;
		}
	}
	public static int sum() {
		int sum = 0;
		for(int i = 0; i<N-1; i++) {
			sum += Math.abs(selected[i]-selected[i+1]);
		}
		return sum;
	}
}
