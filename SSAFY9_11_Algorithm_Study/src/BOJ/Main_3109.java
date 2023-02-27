package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_3109 {
	static int count; //정답 수
	static boolean[][] map; // 빵집이 있는 마을
	static int R, C;
	static boolean reached; // 파이프가 근처 빵집의 가스관에서 원웅이네 빵집까지 도달했을 때 체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		map = new boolean[R][C];
		for(int i = 0; i<R; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j = 0; j<C; j++) {
				if(chars[j] == '.') map[i][j] = true;//.인 곳만 true, x인 곳은 false
			}
		}
		for(int i = 0; i<R; i++) {//행을 돌면서 열을 체크할거다
			reached = false;
			pipe(i, 0);
			if(reached) count++;
		}
		System.out.println(count);
	}
	
	public static void pipe(int x, int y) {//(행, 열)
		//0~C-1열까지 돌면 도달 true
		if(y == C) {
			reached = true;
			return;
		}
		
		if(x<0 || y<0 || x>=R || y>=C) return; //범위 체크
		if(!map[x][y]) return; //파이프 및 건물 체크
		if(reached) return; //도달 체크(오위, 오른, 오아래 순인데 이미 오위에서 도달했으면 아래는 하면 안됨)
		
		map[x][y] = false; //파이프 설치
		
		pipe(x-1, y+1);
		pipe(x, y+1);
		pipe(x+1, y+1);
		return;
	}
}