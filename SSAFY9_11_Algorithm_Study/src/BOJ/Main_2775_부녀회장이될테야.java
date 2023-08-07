package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_부녀회장이될테야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T; tc++) {
			int k = Integer.parseInt(br.readLine()); //k층
			int n = Integer.parseInt(br.readLine()); //n호
			int[][] apt = new int[k+1][n+1];
			for(int i = 1; i<=n; i++) {
				apt[0][i] = i;
			}
			
			for(int i = 1; i<=k; i++) {
				for(int j = 1; j<=n; j++) {
					apt[i][j] = apt[i][j-1] + apt[i-1][j];
				}
			}
			
			System.out.println(apt[k][n]);
		}
	}
}
