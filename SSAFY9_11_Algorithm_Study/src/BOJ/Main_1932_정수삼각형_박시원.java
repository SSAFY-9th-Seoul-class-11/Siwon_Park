package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] tri = new int[n][n];
		int[][] sum = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<=i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum[0][0] = tri[0][0];
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<=i; j++) {
				if(j == 0) {
					sum[i][j] = sum[i-1][0] + tri[i][j]; 
				}else if(j == i) {
					sum[i][j] = sum[i-1][j-1] + tri[i][j];
				}else {
					sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]) + tri[i][j];
				}
			}
		}
		
		int max = 0;
		for(int j = 0; j<n; j++) {
			max = Math.max(max, sum[n-1][j]);
		}
		System.out.println(max);
	}

}
