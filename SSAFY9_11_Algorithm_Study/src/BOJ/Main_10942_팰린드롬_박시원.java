package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬_박시원 {
	
	static int N, M, s, e;
	static int[] num;
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 칠판에 적은 수열의 크기
		num = new int[N+1]; // 칠판의 적은 수 배열
		dp = new boolean[N+1][N+1]; // 첫번재 인덱스부터 두번째 인덱스까지가 팰린드롬인지
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp();
        
		StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine()); // 질문의 개수
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			if (dp[s][e]) {
				sb.append(1+"\n");
            } else {
            	sb.append(0+"\n");
            }
	    }
		System.out.println(sb);
	}
	
	public static void dp() {
		//s==e
        for (int i=1; i<=N; i++) {
            dp[i][i] = true;
        }
        //s==e+1
        for (int i=1; i<N; i++) {
            if (num[i] == num[i+1]) dp[i][i+1] = true;
        }
        //s-e>2
        for (int i=2; i<N; i++) {// s-e 인덱스 (수열의 길이가 3이상일 때,, 차이가 2 이상일 때)
            for (int j=1; j<=N-i; j++) {
                if (num[j] == num[j+i] && dp[j+1][j+i-1]) { //num[s]num[e]가 같고, 그 안에 것들이 같을 때
                    dp[j][j+i] = true;
                }
            }
        }
	}
}
