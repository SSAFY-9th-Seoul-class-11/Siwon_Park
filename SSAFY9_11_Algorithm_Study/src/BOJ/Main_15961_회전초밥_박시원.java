package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥_박시원 {
	static int N, d, k, c;
	static int[] belt, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		belt = new int[N];
		for(int i = 0; i<N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		visited = new int[d+1]; // 각 번호마다 먹은 스시 개수를 저장할 배열
		
		System.out.println(slide());
	}

	public static int slide() {
		int enent1 =0, event2 = 0;
		// 처음 k개로 1번 행사 참여하기 
		for (int i = 0; i < k; i++) {
			if(visited[belt[i]] == 0) enent1++;
			visited[belt[i]]++;
		}

		event2 = enent1; // 2번 행사(찬스 번호) 까지 고려
		for (int i = 1; i < N; i++) {
			if(event2<=enent1) { 
				if(visited[c]==0) event2 = enent1+1; // 찬스번호 안썼으면 +1
				else event2 = enent1; //아님 똑같이
			}
			// 슬라이드 이동 시, 앞쪽 스시는 못먹게 되고, 한번도 먹은 적이 없다면 먹은 스시 개수-1
			visited[belt[i-1]]--;
			if(visited[belt[i-1]]==0) enent1--;
			// 다음 스시 먹은 적 없다면 +1, 회전하므로 %N해야 한다
			if(visited[belt[(i-1+k)%N]]==0) enent1++;
			visited[belt[(i-1+k)%N]]++;
		}
		return event2;
	}
}
