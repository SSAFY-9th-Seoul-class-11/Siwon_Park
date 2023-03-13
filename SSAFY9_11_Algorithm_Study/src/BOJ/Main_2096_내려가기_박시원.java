package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_내려가기_박시원 {

	static int N;
	static int[][] minCost, maxCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		minCost = new int[N][3];
		maxCost = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				minCost[i][j] = maxCost[i][j ]= Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(findMax() + " " + findMin());
	}
	//위치, 최소, 최대 별로 다음값 찾아주는 함수
	public static int nextLine(int n, int num, boolean mod) { // 행, 열, mod=true: 최소, false: 최대
		if(num == 0) { // 0, 1 중에서
			if(mod) {
				return Math.min(minCost[n-1][0], minCost[n-1][1]);
			}else {
				return Math.max(maxCost[n-1][0], maxCost[n-1][1]);
			}
		}else if(num == 1) { // 0, 1, 2
			if(mod) {
				return Math.min(minCost[n-1][0], Math.min(minCost[n-1][1], minCost[n-1][2]));
			}else {
				return Math.max(maxCost[n-1][0], Math.max(maxCost[n-1][1], maxCost[n-1][2]));
			}			
		}else{ //(num==2) 1, 2
			if(mod) {
				return Math.min(minCost[n-1][1], minCost[n-1][2]);
			}else {
				return Math.max(maxCost[n-1][1], maxCost[n-1][2]);
			}
		}
	}
	//dp로 최솟값 찾기
	public static int findMin() {
		for(int i = 1; i<N; i++) {
			minCost[i][0] += nextLine(i, 0, true);
			minCost[i][1] += nextLine(i, 1, true);
			minCost[i][2] += nextLine(i, 2, true);
		}
		return(Math.min(minCost[N-1][0], Math.min(minCost[N-1][1], minCost[N-1][2])));	
	}
	//dp로 최댓값 찾기
	public static int findMax() {
		for(int i = 1; i<N; i++) {
			maxCost[i][0] += nextLine(i, 0, false);
			maxCost[i][1] += nextLine(i, 1, false);
			maxCost[i][2] += nextLine(i, 2, false);
		}
		return(Math.max(maxCost[N-1][0], Math.max(maxCost[N-1][1], maxCost[N-1][2])));	
	}
}
