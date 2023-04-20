package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040_사이클게임_박시원 {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());//점의 개수
		int m = Integer.parseInt(st.nextToken());//진행된 차례 수
		
		for(int i = 0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			parent[a] = b;
		}

	}

	// 부모를 찾아주는 함수
	public static int find(int x) {
		if (parent[x] == x) // 부모가 자기 자신이면 본인 리턴
			return x;
		else// 아니라면 부모의 부모를 찾아줘서 리턴
			return parent[x] = find(parent[x]);
	}

	// 유니온 함수! 원소 a와 b를 합쳐주는 함수
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) // a와 b의 부모가 다르다면
			parent[b] = a; // b의 부모를 a의 부모와 같게 한다
	}

}
