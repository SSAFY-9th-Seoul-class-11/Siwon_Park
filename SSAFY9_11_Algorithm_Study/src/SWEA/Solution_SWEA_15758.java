package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_15758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String S = st.nextToken();
			String T = st.nextToken();
			//System.out.println("S"+ S + "T"+ T);
			
			int max = Math.max(S.length(), T.length());//둘 중 큰 수의 길이
			int min = Math.min(S.length(), T.length());//둘 중 작은 수의 길이
			
			int gcd = 0;//최대공약수 구하기
			for(int i =1; i<=min; i++) {
				if(max%i == 0 && min%i == 0) gcd = i;
			}
			
			int lcm = max*min/gcd;//최소공배수 구하기
			
			String s = S;
			String t = T;
			
			//각 문자열이 최소 공배수 길이가 될 때까지 더해주기
			while(s.length() < lcm) {
				s += S;
			}
			while(t.length() < lcm){
				t += T;
			}
			
			if(s.equals(t)) {
				System.out.println("#" + tc + " yes");
			}else {
				System.out.println("#" + tc + " no");
			}
		}
		
	}

}
