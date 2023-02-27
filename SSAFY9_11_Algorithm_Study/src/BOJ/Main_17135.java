package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17135 {
	static int N, M, D, count;
	static int[][] map;
	static ArrayList<Integer> archer; //궁수 열좌표
	static int[] dx = {0, -1, 1};
	static int[] dy = {-1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행의 수
		M = Integer.parseInt(st.nextToken()); // 열의 수
		D = Integer.parseInt(st.nextToken()); // 공격 거리 제한

		map = new int[N][M];
		archer = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	public static void killEnemy(ArrayList<Integer> archer) {

	}
	
	public static void bfs() {
		
	}
	//궁수 열좌표 조합으로 뽑기 0~m-1
	public static void comb(int cnt, int start) { //cnt: 현재까지 뽑은 조합 원소 개수, start: 조합 시도할 원소의 시작 인덱스
		if(cnt == 3) {
			//killEnemy(N-1, archer);
			return;
		}
		else {
			for(int i = start; i<M; i++) {
				archer.add(i);
				comb(cnt+1, start+1);
			}
		}
	}
	//적들 한칸씩 내려보내기
	public static void moveEnemy() {
		int[][] temp = new int[N][M];
		for(int i = 0; i<N-1; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 1) {
					temp[i+1][j] = 1;
				}
			}
		}
		map = temp;
	}

}
