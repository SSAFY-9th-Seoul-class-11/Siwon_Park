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
		
		int end = 0; // 젤 먼 값
		int[] dis = new int[n]; // 갇힌섬으로부터 각 작은 돌섬이 떨어져 있는 거리
		for(int i = 0; i<n; i++) {
			dis[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, dis[i]); // 최대값 찾기
		}

		int start = 0; // 젤 가까운 값
		int result = 0; // 최소 거리의 최댓값
		
		while(start<=end) {
			int mid = (start+end)/2; //중간 값
			int pos = 0;
			int count = 0;
			for(int i = 1; i<=n; i++) {
				if(dis[i]-dis[pos] < mid) count++;
				else pos = i;
			}
			if(count > m) {
				end = mid-1;
			} else {
				result = mid;
				start = mid+1;
			}
		}
		System.out.println(result);
	}

}
