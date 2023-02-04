package BOJ;

import java.util.Scanner;

public class Solution_BOJ_4963 {
	
	static int w;//너비
	static int h;//높이
	static int[][] map;//지도
	//상하좌우좌상좌하우상우하
	static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
	static boolean[][] visited;//방문체크
	static int count;//섬count
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//여러개의 테스트 케이스래..
		while (true) {
			w = sc.nextInt();//너비
			h = sc.nextInt();//높이
			
			if(w == 0 && h == 0) break;
			
			map = new int [h][w];
			visited = new boolean[h][w];
			count = 0;
			
			//지도 입력
			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//지도 위치가 땅이고, 방문하지 않았다면 섬 개수++, 탐색
			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						count++;
						DFS(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void DFS(int x, int y) {
		visited[x][y] = true;//방문 체크 먼저!!
		
		for(int i = 0; i<8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			//범위 체크
			if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
			//방문 안한 땅이면 재귀!
			if(map[nx][ny] == 1 && visited[nx][ny] == false) DFS(nx, ny);		
		}
	}
}
