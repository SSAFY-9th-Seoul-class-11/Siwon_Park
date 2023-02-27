package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1873 {
	static int H, W, N;
	static char map[][];
	static char input[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 높이
			W = Integer.parseInt(st.nextToken()); // 너비
			map = new char[H][W];
			// 맵 입력받기
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			N = Integer.parseInt(br.readLine());// 사용자가 넣을 입력의 개수를 나타내는 정수
			input = new char[N]; // 동작 명령어 배열
			input = br.readLine().toCharArray();

			boolean flag = true;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						startGame(i, j, 0); // 전차 있는 곳에서 게임 시작!
						flag = false;
						break;
					}
				}
				if (!flag)
					break;
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static void startGame(int r, int c, int num) { // 전차 위치 r, c , 명령어 배열 인덱스
		if (num == N)
			return;
		switch (input[num]) {
		case 'U':
			map[r][c] = '^'; // 방향 먼저 바꿔줌
			// 범위 체크
			if (r == 0) {
				startGame(r, c, num + 1); // 위로 못가면 해당 위치에서 다음 명령어 실행
				return;
			}
			// 갈 곳이 평지일 때만
			if (map[r - 1][c] == '.') {
				map[r][c] = '.'; // 해당 위치 평지로 바꾸고
				map[r - 1][c] = '^'; // 위로 가준다!
				startGame(r - 1, c, num + 1); // 위에서 다음 명령어 실행
				return;
			}
			startGame(r, c, num + 1);
			break;
		case 'D':
			map[r][c] = 'v';
			if (r == H - 1) {
				startGame(r, c, num + 1);
				return;
			}
			if (map[r + 1][c] == '.') {
				map[r][c] = '.';
				map[r + 1][c] = 'v';
				startGame(r + 1, c, num + 1);
				return;
			}
			startGame(r, c, num + 1);
			break;
		case 'L':
			map[r][c] = '<';
			if (c == 0) {
				startGame(r, c, num + 1);
				return;
			}
			if (map[r][c - 1] == '.') {
				map[r][c] = '.';
				map[r][c - 1] = '<';
				startGame(r, c - 1, num + 1);
				return;
			}
			startGame(r, c, num + 1);
			break;
		case 'R':
			map[r][c] = '>';
			if (c == W - 1) {
				startGame(r, c, num + 1);
				return;
			}
			if (map[r][c + 1] == '.') {
				map[r][c] = '.';
				map[r][c + 1] = '>';
				startGame(r, c + 1, num + 1);
				return;
			}
			startGame(r, c, num + 1);
			break;
		case 'S':
			if (map[r][c] == '^') { // 방향 체크! (윗 방향)
				for (int j = r - 1; j >= 0; j--) { // 맨 윗행까지 포탄 움직이자
					if (map[j][c] == '*') { // 벽돌 벽이라면
						map[j][c] = '.'; // 벽 뚫고 평지로 만들기
						break;
					} else if (map[j][c] == '#')
						break; // 포탄 소멸
				}
			} else if (map[r][c] == 'v') {
				for (int j = r + 1; j < H; j++) {
					if (map[j][c] == '*') {
						map[j][c] = '.';
						break;
					} else if (map[j][c] == '#')
						break;
				}
			} else if (map[r][c] == '<') {
				for (int j = c - 1; j >= 0; j--) {
					if (map[r][j] == '*') {
						map[r][j] = '.';
						break;
					} else if (map[r][j] == '#')
						break;
				}
			} else if (map[r][c] == '>') {
				for (int j = c + 1; j < W; j++) {
					if (map[r][j] == '*') {
						map[r][j] = '.';
						break;
					} else if (map[r][j] == '#')
						break;
				}
			}
			startGame(r, c, num + 1);
			break;
		}
		return;
	}

}
