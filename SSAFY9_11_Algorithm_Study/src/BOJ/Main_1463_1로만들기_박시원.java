package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] f = new int[N+1];
		f[0] = 0;
		f[1] = 0;
		for(int i = 2; i<=N; i++) {
			f[i] = f[i-1] + 1;
			if (i % 2 == 0) f[i] = Math.min(f[i], f[i/2] + 1);
	        if (i % 3 == 0) f[i] = Math.min(f[i], f[i/3] + 1);
		}
		System.out.println(f[N]);
	}

}
