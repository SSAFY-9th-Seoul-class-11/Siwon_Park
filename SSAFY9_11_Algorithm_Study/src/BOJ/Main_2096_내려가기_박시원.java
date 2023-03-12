package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_내려가기_박시원 {

	static int N;
	static int[][] map, minCost, maxCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minCost = new int[N][3];
		maxCost = new int[N][3];
		for (int i = 0; i < 3; i++) {
			minCost[N - 1][i] = maxCost[N - 1][i] = map[N - 1][i];
		}
		int min = Math.min(findMin(0, 0), Math.min(findMin(0, 1), findMin(0, 2)));
		int max = Math.max(findMax(0, 0), Math.max(findMax(0, 1), findMax(0, 2)));
		
		System.out.println(max + " " + min);
	}
	//최소, 최댓값 재귀로 찾아주는 함수
	public static int nextLine(int n, int num, boolean mod) { // 행, 열, mod=true: 최소, false: 최대
		if(num == 0) { // 0, 1 중에서
			if(mod) {
				return Math.min(findMin(n+1, 0), findMin(n+1, 1));
			}else {
				return Math.max(findMax(n+1, 0), findMax(n+1, 1));
			}
		}else if(num == 1) { // 0, 1, 2
			if(mod) {
				return Math.min(findMin(n+1, 0), Math.min(findMin(n+1, 1), findMin(n+1, 2)));
			}else {
				return Math.max(findMax(n+1, 0), Math.max(findMax(n+1, 1), findMax(n+1, 2)));
			}			
		}else{ //(num==2) 1, 2
			if(mod) {
				return Math.min(findMin(n+1, 1), findMin(n+1, 2));
			}else {
				return Math.max(findMax(n+1, 1), findMax(n+1, 2));
			}
		}
	}
	//dp로 최솟값 찾기
	public static int findMin(int n, int num) {
		if(n<N-1) { // 탐색하지 않은 배열만 탐색!
			minCost[n][num] = map[n][num] + nextLine(n, num, true);
		}
		return minCost[n][num];
	}
	//dp로 최댓값 찾기
	public static int findMax(int n, int num) {
		if(n<N-1) { // 탐색하지 않은 배열만 탐색!
			maxCost[n][num] = map[n][num] + nextLine(n, num, false);
		}
		return maxCost[n][num];
	}

}
