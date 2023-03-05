package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class core {
	int x, y;
	core(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_1767_프로세서연결하기_박시원 {

	static int N, wire, min;
	static int[][] processor, wireOn;
	static boolean[] isSelected;
	static core core[];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 프로세서 크기
			min = Integer.MAX_VALUE;
			wire = 0;

			processor = new int[N][N];
			wireOn = new int[N][N];			

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					processor[i][j] = wireOn[i][j] = Integer.parseInt(st.nextToken());
					if(processor[i][j] == 1) wire++;
				}
			}
			
			core = new core[wire];
			isSelected = new boolean[wire];
			
			int c = 0;
			for(int i = 1; i<N-1; i++) {
				for(int j = 1; j<N-1; j++) {
					if(processor[i][j] == 1) core[c++] = new core(i, j);
				}
			}
			

			System.out.println("#" + tc + " " + min);
		}
	}

	public static void start() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (processor[i][j] == 1)
					connect(i, j);
			}
		}
	}

	public static void connect(int x, int y) {
		
		for(int d = 0; d<4; d++) {
			int nx = x;
			int ny = y;
			//isSelected = new boolean[N][N];
			while(nx>=0 || nx<N || ny>=0 || ny<N ) {
				nx += dx[d];
				ny += dy[d];
				if(processor[nx][ny] != 0) {
					
					break;
				}
				//isSelected[nx][ny] = true;
			}
		
			
		}
	}
}
