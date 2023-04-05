package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥_박시원 {
	static int N, d, k, c, cnt;
	static int[] belt, visited; //
	

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
		visited = new int[d+1]; // 번호마다 먹은 스시 개수를 저장할 배열
	}

	public static void slide() {
		int total=0;
		for (int i = 0; i < k; i++) {
			if(visited[belt[i]] ==0) total++;
			visited[belt[i]]++;
		}
		cnt = total;
		//찬스까지 고려해보자
		for (int i = 1; i < N; i++) {
			if(cnt<=total) {//슬라이드에 찬스 번호가 들어있지 않으면 1개를 더 먹을 수 있다
				if(visited[c]==0) {
					cnt = total+1;
				}else {
					cnt = total;
				}
			}
			// 슬라이드 이동 시, 앞쪽 스시는 못먹게 되고, 한번도 먹은 적이 없으면 슬라이드 내에서 먹은 스시 개수-1
			visited[belt[i-1]]--;
			if(visited[belt[i-1]]==0)total--;
			
			if(visited[belt[(i+k-1)%N]]==0)total++;
			visited[belt[(i+k-1)%N]]++;
		}
	}
}
