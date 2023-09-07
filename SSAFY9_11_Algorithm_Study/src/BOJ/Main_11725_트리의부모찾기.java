package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	static ArrayList<Integer>[] node;
	static boolean[] visited;
	static int[] parent;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		node = new ArrayList[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			node[i] = new ArrayList<>();
		}
		
		int a = 0; int b = 0;
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			node[a].add(b);
			node[b].add(a);
		}
		dfs(1);
		for(int i = 2; i<=N; i++) {
			System.out.println(parent[i]);
		}
		
	}
	public static void dfs(int num) {
		visited[num] = true;
		for(int i : node[num]) {
			if(visited[i]) continue;
			parent[i] = num;
			dfs(i);
		}
	}
}
