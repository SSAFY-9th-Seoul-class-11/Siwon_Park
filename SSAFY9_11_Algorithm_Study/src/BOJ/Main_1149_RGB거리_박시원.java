package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리_박시원 {

	static int N, result; //집의 수, 최솟값
	static int[][] cost, minCost; //[집 인덱스][빨파노]
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		minCost = new int[N][3];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i<3; i++) {
			minCost[N-1][i] = cost[N-1][i];
		}
		result = Math.min(findMin(0, 0), Math.min(findMin(0, 1), findMin(0, 2)));
		System.out.println(result);
	}
	
	public static int findMin(int n, int color) {
		if(minCost[n][color] == 0) { // 탐색하지 않은 배열만 탐색!
			if(color == 0) { //빨강일 때 다음 집의 색은 초록, 파랑만 가능
				minCost[n][0] = cost[n][0] + Math.min(findMin(n+1, 1), findMin(n+1, 2));
			}else if(color == 1){
				minCost[n][1] = cost[n][1] + Math.min(findMin(n+1, 0), findMin(n+1, 2));
			}else if(color == 2){
				minCost[n][2] = cost[n][2] + Math.min(findMin(n+1, 0), findMin(n+1, 1));
			}
		}
		return minCost[n][color];
	}
}