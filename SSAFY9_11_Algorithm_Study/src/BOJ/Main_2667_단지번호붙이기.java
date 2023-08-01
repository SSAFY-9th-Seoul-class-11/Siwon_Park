package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static class Pos {
		int x, y;
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str;
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		int num = 0; // 단지 번호
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				//0이 아니고 방문하지 않았을 때만 시작
				if(map[i][j]!=0 && !visited[i][j]) { 
					dfs(new Pos(i, j), ++num);
				}
			}
		}
		System.out.println(num);
		int[] cnt = new int[num+1];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				cnt[map[i][j]]++; // 단지 번호 cnt++
			}
		}
		cnt[0]=0; // 0도 세져서 0으로 업뎃
		Arrays.sort(cnt); // 오름차순 정렬
		for(int i = 1; i<=num; i++) { // 정렬했으니까 0 빼고 출력
			System.out.println(cnt[i]);
		}
	}
	public static void dfs(Pos p, int num) {
		if(visited[p.x][p.y]) return;
		visited[p.x][p.y] = true;
		map[p.x][p.y] = num; // 단지 번호로 바꿔주기
		for(int i = 0; i<4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue; // 범위체크
			if(map[nx][ny]==0) continue; // 집 없는거 체크
			if(visited[nx][ny]) continue; // 방문체크
			dfs(new Pos(nx, ny), num);
		}
	}
}
