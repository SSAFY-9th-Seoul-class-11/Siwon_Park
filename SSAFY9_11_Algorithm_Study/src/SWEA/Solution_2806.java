package SWEA;

import java.util.Scanner;

public class Solution_2806 {
	static int count; //정답 수
	static int[] board; // 체스판 board의 인덱스(y)는 행, 값(x)은 열 board[y]=x

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //NxN 체스판
			count = 0; 
			board = new int[N];
			
			dfs(0, N);
			System.out.println("#" + tc + " " + count);	
		}		
	}
	
	public static void dfs(int start, int N) {
		//0~N행까지 돌면 정답++
		if(start == N) {
			count++;
			return;
		}
		//열 돌면서 행 체크
		for(int x = 0; x<N; x++) {
			boolean visited = true; //방문 체크
			for(int y = 0; y<start; y++) {
				//위에서 놓은 퀸과 같은 열, 오른아래 대각선, 왼아래 대각션 을 지나기에 퀸을 놓을 수 없음
				if(board[y] == x || board[y]+(start-y) == x || board[y]-(start-y) == x) {
					visited = false;
					break;
				}
			}
			if(visited) {
				board[start] = x;
				dfs(start+1, N);
			}
		}
	}


}
