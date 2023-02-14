package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_6209 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int d = Integer.parseInt(st.nextToken()); // 갇힌 돌섬으로부터 탈출구까지의 거리
		int n = Integer.parseInt(st.nextToken()); // 작은 돌섬의 수
		int m = Integer.parseInt(st.nextToken()); // 제거할 수 있는 작은 돌섬의 수
		
		int end = 0; // 젤 먼 거리 값
		int[] dis = new int[n+1]; // 갇힌섬으로부터 각 작은 돌섬이 떨어져 있는 거리
		for(int i = 0; i<n; i++) {
			dis[i] = Integer.parseInt(br.readLine());
		}
		dis[n] = d;
		
		end = d; // 최대값

		int start = 0; // 젤 가까운 거리 값
		int result = 0; // 최소 거리의 최댓값
		
		//이진 탐색 수행
		while(start<=end) {
			int mid = (start+end)/2; //중간 값
			int idx = 0;
			int count = 0; // 제거할 돌섬 수 
			for(int i = 1; i<=n; i++) {
				if(dis[i]-dis[idx] < mid) count++; // 최소거리의 수가 중간 값보다 작으면 돌섬 수를++
				else idx = i;
			}
			if(count > m) { // 제거할 돌섬 수 보다 많으면 거리 값을 줄여야 함
				result = mid; // 최소 거리의 최대 값이므로, 여기에서 result를 기록
				end = mid-1;
			} else { // 제거할 돌섬 수보다 작거나 같으면 거리 값을 길게 해야 함
				//result = mid; // 최소 거리의 최대 값이므로, 여기에서 result를 기록
				start = mid+1;
			}
		}
		System.out.println(result);
	}

}
