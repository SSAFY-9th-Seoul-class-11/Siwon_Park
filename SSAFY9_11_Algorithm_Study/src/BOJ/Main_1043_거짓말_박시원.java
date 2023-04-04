package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1043_거짓말_박시원 {

	static int N, M, cnt;
	static boolean[] knowing;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		knowing = new boolean[k]; //진실을 아는 사람들
		for(int i = 0; i<k; i++) {
			knowing[Integer.parseInt(st.nextToken())] = true;
		}
		
		parent = new int[N + 1]; // 부모 배열
		for (int i = 1; i <= N; i++) {
			parent[i] = i; // 사람들의 부모를 각각 자신으로 초기화
		}
		
		ArrayList<Integer>[] people = new ArrayList[M];
		for(int i=0; i<M; i++) {
			people[i] = new ArrayList<>();
		}
		int a, b =0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N > 0) {
				b = Integer.parseInt(st.nextToken());
				people[i].add(b);
			}
			for(int j=1; j<N; j++) {
				a = Integer.parseInt(st.nextToken());
				people[i].add(a);
				union(b, a); // 두명씩 union하면 모두가 같은 parent를 갖게 됨.
				b = a;
			}
		}
		
		// 진실을 아는 사람들의 parent는 같이 파티를 참여 했으므로 진실을 아는 사람들
		int parent;
		for(int i=1; i<knowing.length; i++) {
			if(knowing[i]) {
				knowing[find(i)] = true;
			}
		}
		
		// 진실을 아는 사람들과 파티를 같이 하지 않았으면 cnt++
		for(int i=0; i<M; i++) {
			if(people[i].size() > 0) {
				parent = find(people[i].get(0));
				if(!knowing[parent]) cnt++;
			}
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
		if (a != b)
			parent[b] = a;
	}
}
