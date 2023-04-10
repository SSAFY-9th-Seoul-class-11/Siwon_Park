package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16919_봄버맨2_박시원 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int R, C, N;
	static char[][] map;
	static int[][] bomb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		bomb = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'O') {
					bomb[i][j] = 0;
				}
			}
		}
		if(N == 1) {
			print();
		}else {
			N %= 4;
			if(N == 0) N = 2;
			else if(N == 1) N = 5;
			installation(2);
		}
	}

	// 폭탄 설치하기
	public static void installation(int now) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
					bomb[i][j] = now;
				}
			}
		}

		if(now == N) {
			print();
			return;
		}
		explosion(now+1);
	}

	// 폭탄 터뜨리기
	public static void explosion(int now) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (bomb[i][j] == now - 3) {
					map[i][j] = '.';
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
						map[nx][ny] = '.';
					}
				}
			}
		}
		
		if(now == N) {
			print();
			return;
		}
		installation(now+1);
	}
	
	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
