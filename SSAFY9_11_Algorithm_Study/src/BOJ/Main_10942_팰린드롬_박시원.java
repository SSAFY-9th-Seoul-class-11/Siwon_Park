package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬_박시원 {
	
	static int N, M;
	static int[] num, S, E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 칠판에 적은 수열의 크기
		num = new int[N+1]; // 칠판의 적은 수 배열
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine()); // 질문의 개수
		S = new int[M+1]; // 시작 수
		E = new int[M+1]; // 끝 수
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			E[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=M; i++) {
			boolean flag = true;
			for(int j = 0; j<=(E[i]-S[i])/2; j++) {
				if(num[S[i]+j] != num[E[i]-j]) {
					System.out.println(0);
					flag = false;
					break;
				}
			}
			if(flag) System.out.println(1);
		}
	}
}
