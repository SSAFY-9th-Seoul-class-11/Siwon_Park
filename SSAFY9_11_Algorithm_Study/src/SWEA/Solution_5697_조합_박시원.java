package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5697_조합_박시원 {

	static int N, R, P = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long r=nCr(N,R);
			System.out.println("#" + tc + " " + (r)%P);
		}
	}
	
	static long fact(long n) {
		long re=1L;
		for (int i = 1; i <= n; i++) {
			re*=i;
			re%=P;
		}
		return re%P;
	}
	static long nCr(long n, long r) {
		long re=1L;
		re*=fact(n);
		re%=P;
		re*=pow(fact(n-r),P-2);
		re%=P;
		re*=pow(fact(r),P-2);
		re%=P;
		return re;
	}
	static long pow(long x, long y) {
		long re=1L;
		while(y>0) {
			if(y%2==1) {
				re*=x;
				re%=P;
			}
			x*=x;
			x%=P;
			y/=2;
		}
		return re%P;
	}
}
