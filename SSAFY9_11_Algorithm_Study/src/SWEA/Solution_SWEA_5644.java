package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5644 {

	static int[][] map = new int[10][10];
	static int[][] pA, pB;// 사용자 A, B 이동 경로 [][0]->x, [][1]->y
	static int M;//총 이동 시간
	static int A;//BC의 개수
	//이동 x, 상, 우, 하,좌
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			A = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				pA[i][0] = Integer.parseInt(st.nextToken());
				pA[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				pB[i][0] = Integer.parseInt(st.nextToken());
				pB[i][0] = Integer.parseInt(st.nextToken());
			}
		}

	}
	public static void coverage() {
		
	}

}
