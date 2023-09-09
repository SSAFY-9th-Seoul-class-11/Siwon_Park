package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	static int[][] G;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k<N; k++) {//경유
			for(int i = 0; i<N; i++) {//출발
				for(int j = 0; j<N; j++) {//도착
					if(G[i][k]==1&&G[k][j]==1) G[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(G[i][j] + " ");
			}
			System.out.println();
		}
	}
}
