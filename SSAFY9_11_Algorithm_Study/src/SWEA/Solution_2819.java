package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2819 {
	static Set<Object> hset;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static String[][] board = new String[4][4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			hset = new HashSet<Object>();
			//4x4 배열 격자판 입력받기
			for(int i = 0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<4; j++) {
					board[i][j] = st.nextToken();
				}
			}
			//DFS
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<4; j++) {
					DFS(i, j, board[i][j], 1);
				}
			}
			System.out.println("#" + tc + " " + hset.size());
			//System.out.println(hset);
		}
	}
	
	//s: 격자판 숫자 7개 합칠 String, cnt: 인접한 격자로 이동하는 횟수
	public static void DFS(int x, int y, String s, int cnt) {
		if(cnt > 6) {
			hset.add(s);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			//범위 체크
			if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
			DFS(nx, ny, s+board[nx][ny], cnt+1);	
		}
	}

}
