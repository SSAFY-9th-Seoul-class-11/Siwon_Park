package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17471 {

	static int N, min;
	static int[] population;
	static boolean[][] graph; //배열1에 배열2 인덱스에 해당하는 정점이 있다면 true => 두 정점이 연결되어있다
	static boolean[] visited, zone12; //방문체크, zone1이면 true, zone2면 false
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		zone12 = new boolean[N+1];
		graph = new boolean[N+1][N+1];
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j<cnt; j++ ) {
				int x = Integer.parseInt(st.nextToken());
				graph[i][x] = true;
			}
		}
		
		divide(1);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	public static void divide(int idx) {
		if(idx == N) {
			int zone1 = 0, zone2 = 0;
			for(int i = 1; i<=N; i++) {
				if(zone12[i]) {
					zone1 += population[i];
				}else {
					zone2 += population[i];
				}
			}
			visited = new boolean[N+1]; // 매번 새로운 방문체크
			int count = 0; // 선거구 수
			for(int i = 1; i<=N; i++) {
				if(!visited[i])	{
					check(i, zone12[i]);
					count++;
				}
			}
			if(count == 2) {
				min = Math.min(min, Math.abs(zone1-zone2));
			}
			return;
		}
		
		
		zone12[idx] = true;
		divide(idx+1);
		zone12[idx] = false;
		divide(idx+1);
		
	}
	public static void check(int n, boolean zone) {
		visited[n] = true;
		for(int i = 1; i<=N; i++) {
			if(graph[n][i] && !visited[i] && zone12[i] == zone) {
				check(i, zone);
			}
		}
	}
}
