package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1010_다리놓기_박시원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(fac(M).divide(fac(N)).divide(fac(M-N)));
		}
	}
	public static BigInteger fac(int n) {
		BigInteger result = BigInteger.valueOf(1);
		if(n==0) return result;
		for(int i = n; i>=1; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
