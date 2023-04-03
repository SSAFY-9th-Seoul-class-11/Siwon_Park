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
		int value, pre =0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N > 0) {
				pre = Integer.parseInt(st.nextToken());
				people[i].add(pre);
			}
			for(int j=1; j<N; j++) {
				value = Integer.parseInt(st.nextToken());
				people[i].add(value);
				union(pre, value); // 두명씩 union하면 모두가 같은 parent를 갖게 됨.
				pre = value;
			}
		}
		
		// 4. 진실을 아는 사람들의 parent는 같이 파티를 참여 했으므로 진실을 아는 사람들
		int parent;
		for(int i=1; i<knowing.length; i++) {
			if(knowing[i]) {
				knowing[find(i)] = true;
			}
		}
		
		// 5. 진실을 아는 사람들과 파티를 같이 하지 않았으면 total++
		for(int i=0; i<M; i++) {
			if(people[i].size() > 0) {
				parent = find(people[i].get(0));
				if(!knowing[parent]) cnt++;
			}
		}

		// 6. 거짓말 할 수 있는 파티 최대 수 출력
		System.out.println(cnt);
	}
	
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
		if (a != b) //a와 b의 부모가 다르다면
			parent[b] = a; //b의 부모를 a의 부모와 같게 한다
	}

}
