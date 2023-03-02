package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_박시원 {
	static int N, W, H, min; // 구슬 수, 너비, 높이, 남은 벽돌의 최솟값(벽돌을 최대한 많이 제거해야 하므로)
	static int[][] map, temp;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Point {
		int x;
		int y;
		int size;

		public Point(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			drop(map, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	//구슬 떨어뜨리기
	public static void drop(int[][] map, int cnt) {// cnt: 구슬을 떨어뜨린 횟수
		if (cnt == N) {
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0)	count++; //비어있지 않다면 벽돌 세주자
				}
			}
			min = Math.min(min, count);
			return;
		}

		temp = new int[H][W];
		
		// 열 돌면서 구슬 떨어뜨릴 행 찾자!
		for (int y = 0; y < W; y++) {
			int x = 0;
			while (x < H && map[x][y] == 0)	x++; // 해당 열에서 가장 위에있는 행 인덱스 찾기

			if (x == H) { //벽돌 없음 넘어가기 구슬 수++
				drop(map, cnt + 1);
			} else {
				// 배열 옯겨서 해야함
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						temp[i][j] = map[i][j];
					}
				}
				bomb(temp, x, y); // 벽돌 부수고
				down(temp); // 벽돌 내리고
				drop(temp, cnt + 1);// 다음 구슬 떨어뜨리러 가자
			}
		}
	}
	//큐를 사용해 행을 내려준다
	public static void down(int[][] temp) {
		for (int y = 0; y < W; y++) {
			Queue<Integer> queue = new LinkedList<>();
			int x = H - 1;
			//아래 행부터 값이 있는 것들은 큐에 넣고 배열은 0으로 바꿔줌
			while (x >= 0) {
				if (temp[x][y] > 0) {
					queue.offer(temp[x][y]);
					temp[x][y] = 0;
				}
				x--;
			}

			x = H - 1;
			// 배열에 다시 값 넣기(0뺀 값 완성!)
			while (!queue.isEmpty()) {
				temp[x][y] = queue.poll();
				x--;
			}
		}
	}
	// 벽돌 부수기
	public static void bomb(int[][] temp, int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		if (temp[x][y] > 1) {
			queue.offer(new Point(x, y, temp[x][y]));
		}
		temp[x][y] = 0; // 제거

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) { //4방으로 가는데
				int nx = p.x;
				int ny = p.y;
				for (int j = 1; j < p.size; j++) { //해당 사이즈만큼 커지면서!!
					nx += dx[i]; 
					ny += dy[i];

					if(nx<0 || nx>=H || ny<0 || ny>=W) continue; //범위체크
					if(temp[nx][ny] == 0) continue; //0 패스

					queue.offer(new Point(nx, ny, temp[nx][ny])); //큐에 넣어주고
					temp[nx][ny] = 0; //없앤다
				}
			}
		}
	}
}
