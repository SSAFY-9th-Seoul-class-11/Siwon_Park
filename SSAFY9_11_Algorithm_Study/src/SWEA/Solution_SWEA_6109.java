package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6109 {
	static int N;
	static String S;
	static int[][] tile;
	static int[][] temp;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			N = Integer.parseInt(st.nextToken());//NxN행
			S = st.nextToken();//상하좌우 입력
			tile = new int[N][N];
			
			//타일 입력받기
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					tile[i][j] = Integer.parseInt(st.nextToken());
				}
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
					//행이 0이 아닌 것 중에서 왼쪽 열 숫자와 같고, 방문 안했다면 
					if(k>0 && temp[i][k-1] == temp[i][k] && !visited[i][j]) {
						visited[i][k-1] = true;//방문체크 하고
						temp[i][k-1] *= 2;//왼쪽열 숫자는 x2
						temp[i][k] = 0;//해당 행은 0
					}else {
						k++;
					}
				}
			}
			break;
			
		case "right": 
			for(int i = 0; i<N; i++) {
				int k = 0;//temp의 행 변수
				for(int j = N-1; j>=0; j--) {
					if(tile[i][j] == 0) continue;
					
					temp[i][k] = tile[i][j];//숫자 오른쪽으로 밀기!
					//행이 N-1이 아닌 것 중에서 오른쪽 열 숫자와 같고, 방문 안했다면 
					if(k<N-1 && temp[i][k-1] == temp[i][k] && !visited[i][j]) {
						visited[i][k+1] = true;//방문체크 하고
						temp[i][k+1] *= 2;//오른쪽 숫자는 x2
						temp[i][k] = 0;//해당 행은 0
					}else {
						k++;
					}
				}
			}
			break;
		case "up": 
			break;
		case "down": 
			break;
		}
		
	}

}
