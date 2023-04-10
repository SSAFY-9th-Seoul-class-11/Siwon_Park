package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_구간합구하기_박시원 {

	static int N, M, K;
	static long[] tree;
	static long[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree=new long[N+1];
		nums=new long[N+1];
		
		for(int i = 1; i<=N; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
	}

}
