package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1954 {
	static int N;
	static int[][] num; //달팽이 숫자를 받을 배열
	static boolean[][] visited;//방문체크
	static int sNum = 1;//달팽이 배열에 넣을 숫자
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//테스트케이스 입력
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());//N 입력
			num = new int[N+1][N+1];//배열 초기화
			visited = new boolean[N+1][N+1];
			
			snail(0);
			
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//cnt는 꺾은 횟수, cnt를 4로 나눈 나머지가 0, 1, 2, 3 순으로 오(열++), 아래(행++), 왼(열--), 위(행--)
	public static void snail(int cnt) {		
		if(cnt > 2*(N-1)) return; //꺾어야 하는 수보다 크다면 return

		switch(cnt%4) {
		case 0: //오
			for(int i = 1; i<=N; i++) {
				if(visited[cnt/4][i]) continue; //방문했으면 continue
				num[cnt/4][i] = sNum++;
				visited[cnt/4][i] = true;//방문체크
			}
			break;
		case 1: //아래
			for(int i = 1; i<=N; i++) {
				if(visited[i][N-cnt/4]) continue; //방문했으면 continue
				num[i][N-cnt/4] = sNum++;
				visited[i][N-cnt/4] = true;
			}
			break;
		case 2: //왼
			for(int i = N; i>=1; i--) {
				if(visited[N-cnt/4][i]) continue; //방문했으면 continue
				num[N-cnt/4][i] = sNum++;
				visited[N-cnt/4][i] = true;//방문체크
			}
			break;
		case 3: //위
			for(int i = N; i>=1; i--) {
				if(visited[i][cnt/4]) continue; //방문했으면 continue
				num[i][cnt/4] = sNum++;
				visited[i][cnt/4] = true;
			}
			break;
			
		
		}
		snail(cnt++);
	}
}
