package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획_박시원 {
	static int N, M;
	static int[] parents;
	static Edge[] edges;
	
	static class Edge implements Comparable<Edge> {
		int A, B, C; // A번 집과 B번 집을 연결하는 길의 유지비가 C 

		public Edge(int A, int B, int C) {
			super();
			this.A = A;
			this.B = B;
			this.C = C;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.C, o.C);
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 집의 개수(정점)
		M = Integer.parseInt(st.nextToken()); // 길의 개수(간선)

		edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			// A번 집과 B번 집을 연결하는 길의 유지비가 C 
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(A - 1, B - 1, C);
		}
		Arrays.sort(edges);
		
		make();
		
		long result = 0;
		int bigCost = 0;
		for(Edge edge: edges) {
			if(find(edge.A) == find(edge.B)) continue; //이미 사이클이 발생한 상태면 continue
			result += edge.C;
			union(edge.A, edge.B);
			bigCost = edge.C;
		}
		System.out.println(result-bigCost);

	}
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)	return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	public static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}	
}
