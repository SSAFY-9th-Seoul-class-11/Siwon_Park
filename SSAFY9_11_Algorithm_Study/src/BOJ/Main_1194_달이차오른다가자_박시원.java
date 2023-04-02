package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자_박시원 {
	static class Pos {
		int x, y, cnt, key; // 위치, 이동 횟수, 열쇠

		public Pos(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

	static int N, M; // 미로의 행, 열
	static char[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][64];// a: 1(000001), b: 2(000010), c: 4(000100), d: 8(001000), e: 16(010000), f: 32(100000) 다 더하면 63

		Pos start = null;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					start = new Pos(i, j, 0, 0);
				}
			}
		}
		bfs(start.x, start.y);
	}

	static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();

		q.add(new Pos(x, y, 0, 0));
		visited[x][y][0] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();
			int cnt = p.cnt;
			int key = p.key;

			if (map[p.x][p.y] == '1') { //미로 탈출!
				System.out.println(p.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; //범위 체크
				if (map[nx][ny] == '#' || visited[nx][ny][key]) continue; //벽, 방문 여부 체크

				if (map[nx][ny] - 'a' >= 0 && map[nx][ny] - 'a' < 6) { //abcdef 열쇠일 때
					int k = (1 << (map[nx][ny] - 'a')) | key; // 기존 열쇠와 or 연산을 해주어 열쇠를 더해준다.

					if (!visited[nx][ny][k]) {
						visited[nx][ny][k] = true;
						visited[nx][ny][key] = true;
						q.add(new Pos(nx, ny, cnt + 1, k));
					}
				} else if (map[nx][ny] - 'A' >= 0 && map[nx][ny] - 'A' < 6) { //ABCDEF 문일 떄
					int d = (1 << (map[nx][ny] - 'A')) & key; // 문과 열쇠를 and 연산 해준다. 

					if (d > 0) { // 문과 열쇠를 and 연산한 값이 0보다 크면 해당 열쇠를 가지고 있는 것으로 문을 열 수 있다. 
						visited[nx][ny][key] = true;
						q.add(new Pos(nx, ny, cnt + 1, key));
					}
				} else {
					visited[nx][ny][key] = true;
					q.add(new Pos(nx, ny, cnt + 1, key));
				}
			}
		}
		System.out.println(-1);
	}
}
