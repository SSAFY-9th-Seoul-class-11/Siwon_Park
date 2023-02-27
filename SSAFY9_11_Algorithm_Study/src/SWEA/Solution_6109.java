package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109 {
	static int N;
	static String S;
	static int[][] tile;
	static int[][] temp;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());//NxN행
			S = st.nextToken();//상하좌우 입력
			tile = new int[N][N];
			temp = new int[N][N];
			visited = new boolean[N][N];
			
			//타일 입력받기
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {				
					tile[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//게임 시작!
			game();
			
			System.out.println("#" + tc);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					System.out.print(temp[i][j] + " ");
				}
				System.out.println();
			}
			
		}

	}
	
	public static void game() {
		//i번째 줄(행)의 j번째 정수(열) 
		switch(S) {
		case "left": 
			for(int i = 0; i<N; i++) {
				int k = 0;//temp의 행 변수
				for(int j = 0; j<N; j++) {
					if(tile[i][j] == 0) continue;
					
					temp[i][k] = tile[i][j];//숫자 왼쪽으로 밀기!
					//열이 0보다 큰 것 중에서 왼쪽 열 숫자와 같고, 방문 안했다면 
					if(k>0 && temp[i][k-1] == temp[i][k] && !visited[i][k-1]) {
						visited[i][k-1] = true;//방문체크 하고
						temp[i][k-1] *= 2;//왼쪽열 숫자는 x2
						temp[i][k] = 0;//해당 위치는 0
					}else {
						k++;
					}
				}
			}
			break;
			
		case "right": 
			for(int i = 0; i<N; i++) {
				int k = N-1;//temp의 행 변수
				for(int j = N-1; j>=0; j--) {
					if(tile[i][j] == 0) continue;
					
					temp[i][k] = tile[i][j];//숫자 오른쪽으로 밀기!
					//열이 N-1보다 작은 것 중에서 오른쪽 열 숫자와 같고, 방문 안했다면 
					if(k<N-1 && temp[i][k+1] == temp[i][k] && !visited[i][k+1]) {
						visited[i][k+1] = true;//방문체크 하고
						temp[i][k+1] *= 2;//오른쪽 숫자는 x2
						temp[i][k] = 0;//해당 위치는 0
					}else {
						k--;
					}
				}
			}
			break;
		case "up": 
			for(int j = 0; j<N; j++) {
				int k = 0;//temp의 열 변수
				for(int i = 0; i<N; i++) {
					if(tile[i][j] == 0) continue;
					
					temp[k][j] = tile[i][j];//숫자 위로 밀기!
					//행이 0보다 큰 것 중에서 윗행 숫자와 같고, 방문 안했다면 
					if(k>0 && temp[k-1][j] == temp[k][j] && !visited[k-1][j]) {
						visited[k-1][j] = true;//방문체크 하고
						temp[k-1][j] *= 2;//윗열 숫자는 x2
						temp[k][j] = 0;//해당 위치는 0
					}else {
						k++;
					}
				}
			}
			break;
		case "down": 
			for(int j = 0; j<N; j++) {
				int k = N-1;//temp의 열 변수
				for(int i = N-1; i>=0; i--) {
					if(tile[i][j] == 0) continue;
					
					temp[k][j] = tile[i][j];//숫자 아래로 밀기!
					//행이 N-1보다 작은 것 중에서 아래행 숫자와 같고, 방문 안했다면 
					if(k<N-1 && temp[k+1][j] == temp[k][j] && !visited[k+1][j]) {
						visited[k+1][j] = true;//방문체크 하고
						temp[k+1][j] *= 2;//윗열 숫자는 x2
						temp[k][j] = 0;//해당 위치는 0
					}else {
						k--;
					}
				}
			}
			break;
		}
		
	}

}
