package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취_박시원 {

	static int N, M ,C;
	static int[][] honeyComb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); 
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //벌통 크기
			M = Integer.parseInt(st.nextToken()); //선택할 수 있는 벌통 개수
			C = Integer.parseInt(st.nextToken()); // 최대 양
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					honeyComb[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		}
		

		
	}

}
