package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기_박시원 {

	static int n, m;
	static long[][] city;
	static long[] cost;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 도시 수
		m = Integer.parseInt(br.readLine()); // 버스 수
		city = new long[n+1][n+1];
//		
		for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++){
                if(i == j) continue;
                city[i][j] = Integer.MAX_VALUE;
            }
		}
		
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
		
		cost = city[start].clone();

        visited = new boolean[n+1];
        visited[start] = true;

        for(int i = 1; i<=n; i++) {
            int idx = minIdx();
            visited[idx] = true;

            for(int j = 1; j <= n; j++)
                if(!visited[j])
                	cost[j] = Math.min(cost[j], cost[idx] + city[idx][j]);
        }

        System.out.println(cost[end]);
	}
	
	public static int minIdx(){
        int minIdx = 0;
        long min = Integer.MAX_VALUE;

        for(int i = 1; i<=n; i++){
            if(visited[i]) continue;

            if(min>cost[i]){
                min = cost[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

}
