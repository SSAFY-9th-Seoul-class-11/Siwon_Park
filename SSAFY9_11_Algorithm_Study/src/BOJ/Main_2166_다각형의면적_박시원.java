package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2166_다각형의면적_박시원 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		long[] x = new long[N];
		long[] y = new long[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}
		System.out.printf("%.1f", shoelace(x, y));
	}
	
	public static double shoelace(long[] x, long[] y) {
		double a = 0, b = 0;
		for(int i = 0; i<N; i++) {
			a += x[i]*y[(i+1)%N];
			b += x[(i+1)%N]*y[i];
		}
		return Math.abs(a-b)/2;
	}
}
