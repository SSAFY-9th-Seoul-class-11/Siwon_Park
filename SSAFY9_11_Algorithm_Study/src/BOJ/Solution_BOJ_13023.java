package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_BOJ_13023 {
	static int N, M;
	static ArrayList<Integer>[] friend;
	static int[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
	
		friend = new ArrayList[N]; 
		for(int i = 0; i<N; i++) {
			friend[i] = new ArrayList<Integer>();
		}
		
		int a, b;
		
 		for(int i = 0; i<M; i++) {
 			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			friend[a].add(b);
			friend[b].add(a);
		}

 		for(int i = 0; i<N; i++) {
 			if(result == 1) break;
 			visited = new int[N];
 			visited[i] = 1;
 	 		dfs(i);
 		}
 		System.out.println(result);

	}
	
	
	private static void dfs(int current) { //current: 탐색 정점
		if(result == 1) return;
		if(visited[current] == 5) {
			result = 1;
			return;
		}
		
		//자신의 인접행렬 확인: friend[current] : ArrayList<Integer>
		for(int f : friend[current]) {
			if(visited[f] == 0) {
				visited[f] = visited[current]+1;
				dfs(f);
				visited[f] = 0;
			}
		}
	}
}
