package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] LIS = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {
			LIS[i] = 1; // 자신만 끝에 세웠을 경우 1의 길이
			for (int j = 0; j < i; j++) {
				if(A[j]<A[i] && LIS[i]<LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			}
		}
		int cnt = 1;
		for(int i = 1; i<N; i++) {
			if(LIS[i-1] < LIS[i]) cnt++;
		}
		System.out.println(cnt);
	}

}
