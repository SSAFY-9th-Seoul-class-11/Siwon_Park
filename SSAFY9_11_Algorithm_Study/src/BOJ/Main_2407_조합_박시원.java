package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407_조합_박시원 {

	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		System.out.println(factorial(n).divide(factorial(n-m)).divide(factorial(m)));
	}
	
	public static BigInteger factorial(int n) {
		BigInteger N = BigInteger.ONE;
		for(int i = 1; i<=n; i++) {
			N = N.multiply(new BigInteger(String.valueOf(i)));
		}
		return N;
	}

}
