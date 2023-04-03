package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기_박시원 {
	static int[] x, y;
	static boolean[] checked;
	static int[][] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());//맥주를 파는 편의점의 수
			x = new int[n+2];
			y = new int[n+2];
			dis = new int[n+2][n+2];
			for(int i = 0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());	
			}
			for(int i = 0; i<n+2; i++) {
				for(int j = 0; j<n+2; j++) {
					dis[i][j] = Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
					if(dis[i][j]>1000) dis[i][j] = Integer.MAX_VALUE;
				}
			}
			
			//경, 출, 도 순으로 가자 출과 도는 일정
			for(int k=0; k<n+2; ++k) {
				for(int i = 0; i<n+2; i++) {
					if(i==k) continue; 
					for(int j=0; j<n+2; ++j) {
						if(dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE && dis[i][j] > dis[i][k]+dis[k][j]) {
							dis[i][j] = dis[i][k]+dis[k][j];
						}
					}
				}
			}
			if(dis[0][n+1] != Integer.MAX_VALUE) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}
