package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {
	static ArrayList<Integer>[] node;
	static boolean[] visited;
	static int[] parent;
	static int n, m, a, b, ans; // 전체 사람 수 n, 관계 수 m, 촌수를 계산해야 하는 서로 다른 두 사람의 번호 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		node = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 1; i<=n; i++) {
			node[i] = new ArrayList<>();
		}
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			node[p].add(c);
			node[c].add(p);
		}
		ans = -1;
		dfs(a, b, 0);
		System.out.println(ans);
		
		
	}
	public static void dfs(int start, int end, int cnt) {
		if(start == end) {
			ans = cnt;
			return; 
		}
		
		visited[start] = true;
		for(int i=0; i<node[start].size(); i++) { 
			int next = node[start].get(i);
			if(!visited[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}

}
