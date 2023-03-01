package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//크루스칼 사용
public class Solution_3124 {
	static int V, E;
	static int[] parents;
	static Edge[] edges;

	static class Edge implements Comparable<Edge> {
		int A, B, C; // A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다.

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
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점
			E = Integer.parseInt(st.nextToken()); // 간선

			edges = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				edges[i] = new Edge(A - 1, B - 1, C);
			}
			Arrays.sort(edges);
			
			make();
			
			int cnt = 0;
			long result = 0;
			for(Edge edge: edges) {
				if(union(edge.A, edge.B)) {
					result += edge.C;
					if(++cnt == V-1) break;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
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
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

}
