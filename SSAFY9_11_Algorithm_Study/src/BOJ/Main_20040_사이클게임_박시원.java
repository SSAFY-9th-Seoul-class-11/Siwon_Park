package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040_사이클게임_박시원 {

	static int[] parent;
	static boolean isCycle = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());// 점의 개수
		int m = Integer.parseInt(st.nextToken());// 진행된 차례 수
		int result = 0; // 사이클이 처음으로 만들어진 차례의 번호

		parent = new int[n];
		for (int i = 0; i < n; i++) { //부모를 자기 자신으로 초기화
			parent[i] = i;
        }
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
			if(isCycle) { //사이클이 만들어졌다면!
				result = i; //만들어진 회차 저장
				break;
			}
		}
		System.out.println(result);

	}

	// 유니온 함수! 원소 a와 b를 합쳐주는 함수
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) parent[b] = a; // a와 b의 부모가 다르다면 b의 부모를 a의 부모와 같게 한다
		else isCycle = true; // 부모가 같다면 사이클 만들어짐!
	}

	// 부모를 찾아주는 함수
	public static int find(int x) {
		if (parent[x] == x) return x;// 부모가 자기 자신이면 본인 리턴
		else return parent[x] = find(parent[x]);// 아니라면 부모의 부모를 찾아줘서 리턴
	}
}
