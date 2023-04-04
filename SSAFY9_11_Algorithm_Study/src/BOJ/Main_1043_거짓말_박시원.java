package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1043_거짓말_박시원 {

	static int N, M, cnt;
	static int[] parent;
	static HashSet<Integer> knowing = new HashSet<>();//진실을 아는 사람들

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		
		parent = new int[N + 1]; // 부모 배열
		for (int i = 1; i <= N; i++) {
			parent[i] = i; // 사람들의 부모를 각각 자신으로 초기화
		}
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		
		if(k != 0) {
			for(int i = 0; i<k; i++) {
				knowing.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		ArrayList<Integer>[] people = new ArrayList[M];
		for(int i=0; i<M; i++) {
			people[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			people[i].add(a);
			for(int j = 1; j<n; j++) {
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
				people[i].add(b);
			}
		}

		for(int i = 0; i<M; i++) {
			boolean flag = true;
			for(int p : people[i]) {
				if(knowing.contains(find(parent[p]))) {
					flag = false;
					break;
				}
			}
			if(flag) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(knowing.contains(b)) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		parent[b] = a;
			
	}
}
