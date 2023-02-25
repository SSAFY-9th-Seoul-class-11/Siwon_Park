package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_BOJ_1987 {
	static int R, C;
	static char[][] board;
	static Set<Object> alphabet = new HashSet<>();
	static int max;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i = 0; i<R; i++) {
			String string = br.readLine();
			board[i] = string.toCharArray();
		}
		max = 0;
		alphabet.add(board[0][0]);
		
		dfs(0, 0, 1);
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int count) {
		// 조건이 맞을 때 return  하는 코드가 필요하다
		if(max<count) max = count;
		int dirCnt = 0;
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue; // 범위 체크
			if(alphabet.contains(board[nx][ny])) {
				dirCnt++; // 못갈 때마다 카운트 세주기
				if(dirCnt == 4)return; // 사방 다 막혔다면 리턴
				continue; // 이미 나온 알파벳이면 넘어가기
			}
			alphabet.add(board[nx][ny]);
			dfs(nx, ny, count+1);
			alphabet.remove(board[nx][ny]);
		}
	}

}
