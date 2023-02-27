package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {
	static int N;//식재료 수
	static int[][] table;
	static boolean[] selected;//선택
	static int min;// 맛 차이의 최솟값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine()); //식재료의 수 N, NxN 행렬
			table = new int[N][N];
			selected = new boolean[N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;//비교를 위해 최솟값ㅇ르 최댓값으로 초기화
			dfs(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void dfs(int cnt, int index) {//cnt: 조합 횟수, index: 해당 인덱스
		if(cnt == N/2) { //반만 해보면 됨
			min = Math.min(cal(), min);
			return;
		}

		for(int i = index; i<N; i++) {
			selected[i] =true;
			dfs(cnt+1, i+1);
			selected[i] = false;
		}
	}

	public static int cal() {
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue; //행열 같다면 넘어가기!
				if(selected[i] && selected[j]) { //선택한 애들끼리 더하고
					sum1 += table[i][j];
				}
				else if(!selected[i] && !selected[j]){ //선택 안한 애들끼리 더해서
					sum2 += table[i][j];
				}
			}
		}
		return Math.abs(sum1-sum2);//빼준 절댓값 리턴!
	}
}
