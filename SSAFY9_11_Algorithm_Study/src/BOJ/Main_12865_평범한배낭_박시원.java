package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물건 개수
		int K = Integer.parseInt(st.nextToken()); // 가방의 목표 무게
		
		int[] W = new int[N+1]; // 물건의 무게
		int[] V = new int[N+1]; // 물건의 가치

		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[N+1][K+1]; //가치 합
		
		//초기값 세팅: int[][] 배열의 자동초기화를 이용
		for(int i = 1; i<=N; i++) {//i: 물건
			for(int w = 1; w<=K; w++) {//w: 가방의 무게
				//해당 물건의 무게가 w를 초과하는지 
				if(W[i]>w) {
					D[i][w] = D[i-1][w];
				}else {
					D[i][w] = Math.max(D[i-1][w], V[i]+D[i-1][w-W[i]]);
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
