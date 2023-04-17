package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기_박시원 {

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
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		for(int k = 1; k<=n; k++) {
//			if(k == start || k == end || city[start][k] == 0 || city[k][end] == 0) continue;
			if(city[start][k] != 0 && city[k][end] != 0 && (city[start][end]>city[start][k]+city[k][end] || city[start][end] == 0)) {
				city[start][end] = city[start][k]+city[k][end];
			}
		}
		
		System.out.println(city[start][end]);
	}

}
