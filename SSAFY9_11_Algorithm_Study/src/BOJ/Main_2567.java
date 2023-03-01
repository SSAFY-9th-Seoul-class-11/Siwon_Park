package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567 {
	static boolean[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int length;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수
		map = new boolean[102][102]; //위, 아래, 왼, 오 전부 비어있는지 체크해줘야 하므로
		for(int n = 0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int i  = b; i<b+10; i++) {
				for(int j = a; j<a+10; j++) {
					map[i][j] = true;
				}
			}
		}
		
		for(int x = 1; x<=100; x++) {
			for(int y = 1; y<=100; y++) {
				if(map[x][y]) {
					for(int i = 0; i<4; i++) {
						int nx = x+dx[i];
						int ny = y+dy[i];
						if(nx<0 || nx>101 || ny<0 || ny>101) continue;
						if(!map[nx][ny]) length++;
					}
				}
			}
		}
		System.out.println(length);
	}
}
