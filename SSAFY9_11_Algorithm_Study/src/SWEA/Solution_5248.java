package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// User Problem 5248. [파이썬 S/W 문제해결 구현] 6일차 - 그룹 나누기
public class Solution_5248 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 출석번호
			int M = Integer.parseInt(st.nextToken()); // 신청서 수

			parent = new int[N + 1]; // 부모 배열
			for (int i = 1; i <= N; i++) {
				parent[i] = i; // 각 출석번호의 부모를 해당 출석번호로 초기화
			}
			
			st = new StringTokenizer(br.readLine());
			// M장의 신청서의 두 번호쌍을 입력받아 유니온 연산 해준다
			for (int i = 1; i <= M; i ++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);// 번호쌍 유니온 연산!
			}
			
			Set<Object> hset = new HashSet<>();
			for (int i = 1; i <= N; i++) { // 모든 출석번호의 부모를 set에 넣어줌(중복 없음)
				hset.add(find(i));
			}
			System.out.println("#" + tc + " " + hset.size());
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
		if (a != b) //a와 b의 부모가 다르다면
			parent[b] = a; //b의 부모를 a의 부모와 같게 한다
	}
}
