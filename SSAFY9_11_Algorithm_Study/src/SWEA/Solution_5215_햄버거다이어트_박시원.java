package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//햄버거 재료 수
			int L = Integer.parseInt(st.nextToken());//제한 칼로리
			int[] T= new int[N+1], K = new int[N+1];
			
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());//맛에 대한 점수
				K[i] = Integer.parseInt(st.nextToken());//칼로리
			}
			int[][] D = new int[N+1][L+1];
			
			for(int i = 1; i<=N; i++) {//i: 햄버거 재료
				for(int l = 1; l<=L; l++) {//l: 칼로리
					//해당 재료의 칼로리가 l을 초과하는지 
					if(K[i]>l) {
						D[i][l] = D[i-1][l];
					}else {
						D[i][l] = Math.max(D[i-1][l], T[i]+D[i-1][l-K[i]]);
					}
				}
			}
			System.out.println("#" + tc + " " + D[N][L]);
		}
	}
}
