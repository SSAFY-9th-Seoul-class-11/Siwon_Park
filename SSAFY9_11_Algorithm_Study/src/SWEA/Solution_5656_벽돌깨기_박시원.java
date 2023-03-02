package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_박시원 {
	static int N, W, H; // 구슬 수, 너비, 높이
	static int[][] map;
	private static int[] numbers;
	private static boolean[] isSelected;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			numbers = new int[N];//각 자리에 뽑힌 수
			isSelected = new boolean[W+1];
			

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			permutation(0);

		}

	}

	// 열 N개 뽑은 
	private static void permutation(int cnt) {// 해당 자리에 들어갈 수 뽑기
		if (cnt == N) {
			//System.out.println(Arrays.toString(numbers));
			findStartR(numbers, 0);
			return ;
		}
		for (int i = 0; i <W; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);// 다음 수 뽑으러 가기
			isSelected[i] = false;
		}
	}
	//벽돌 깨뜨리기
	public static void bomb(int x, int y, int weight) {
		System.out.println(map);
		if(map[x][y] == 0) return;
		
		for(int i = 0; i<4; i++) {
			for(int j = 1; j<weight; j++) {
				int nx = x + dx[i]*j;
				int ny = y + dy[i]*j;
				bomb(nx, ny, map[nx][ny]);
				map[nx][ny] = 0;
			}
			
		}
	}

	// 시작 행 찾기
	public static void findStartR(int[] numbers, int idx) { // 열 배열, 인덱스
		for (int i = 0; i < H; i++) {
			if (map[i][numbers[idx]] != 0) {
				bomb(i, numbers[idx], map[i][numbers[idx]]);
				break;
			}
		}
		findStartR(numbers, idx+1);
	}

}
