package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
				
		for(int tc = 0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			for(int i = 0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sticker[0][0] += sticker[1][1];
			sticker[1][0] += sticker[0][1];
			for(int i = 2; i<n; i++) {
				sticker[0][i] += Math.max(sticker[1][i-1], sticker[1][i-2]);
				sticker[1][i] += Math.max(sticker[0][i-1], sticker[0][i-2]);
			}
			
		}
		
	}

}
