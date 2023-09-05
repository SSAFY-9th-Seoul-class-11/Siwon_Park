package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	static boolean[][] node;
	static int[] parent;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		node = new boolean[N+1][N+1];
		parent = new int[N+1];
		int a = 0; int b = 0;
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			node[a][b] = true;
			node[b][a] = true;
		}
		for(int i = 1; i<=N; i++) {
			if(node[1][i]) {
				parent[i] = 1;
				dfs(i);
			}
		}
		for(int i = 2; i<=N; i++) {
			System.out.println(parent[i]);
		}
		
	}
	public static void dfs(int num) {
		for(int i = 1; i<=N; i++) {
			if(i==parent[num]) continue;
			if(node[num][i]) {
				parent[i] = num;
				dfs(i);
			}
		}
	}
}
