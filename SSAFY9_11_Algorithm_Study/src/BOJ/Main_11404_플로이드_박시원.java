package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_플로이드_박시원 {
	
	static int[][] city;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		city = new int[n+1][n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 출발 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 필요 비용
			
			if(city[a][b]<c && city[a][b] != 0) continue; // 입력받은 비용이 이전 비용보다 크면 받지 않음
			city[a][b] = c;
		}
		
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				if(i == k || city[i][k] == 0) continue;
				for(int j = 1; j<=n; j++) {
					//경유 경로가 0이 아니고, 가는 비용이 경유해서 가는 경우보다 크거나, 못가는 경우에 경유해서 가자
					if(city[i][k] != 0 && city[k][j] != 0 && (city[i][j]>city[i][k]+city[k][j] || (i!=j && city[i][j] == 0))) {
						city[i][j] = city[i][k]+city[k][j];
					}
				}
			}
		}
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
	}

}
