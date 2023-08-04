package Softeer;
import java.util.*;
import java.io.*;
public class 로봇이지나간경로 {

	static class Pos{
		int x, y;
		int d; // 방향 인덱스 좌우아래위 순 0123
		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int H, W, cnt;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[] dd = {'<', '>', 'v', '^'};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); //세로크기
        W = Integer.parseInt(st.nextToken()); //가로크기
        map = new char[H][W];
        for(int i = 0; i<H; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        for(int i = 0; i<H; i++) {
        	for(int j = 0; j<W; j++) {
        		if(map[i][j]=='#') {
        			bfs(new Pos(i, j, 0));
        		}
        	}
        }

	}
	
	public static void bfs(Pos pos) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(pos);
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			int x = p.x;
			int y = p.y;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx+dx[i]<0 || nx+dx[i]>=H || ny+dy[i]<0 || ny+dy[i]>=W) continue; // 범위 체크
				if(nx!='#' || nx+dx[i]!='#' || ny!='#' || ny+dy[i]!='#') continue; // 방문 체크
				
			}
		}
	}

}
