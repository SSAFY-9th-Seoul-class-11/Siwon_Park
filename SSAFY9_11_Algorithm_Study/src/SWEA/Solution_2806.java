package SWEA;

import java.util.Scanner;

public class Solution_2806 {
	static int count; //정답 수
	static int[] col; // col의 인덱스(x)는 행, 값(y)은 열 col[x]=y

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //NxN 체스판
			count = 0; 
			col = new int[N];
			
			dfs(0, N);
			System.out.println("#" + tc + " " + count);	
		}		
	}
	
	public static void dfs(int start, int N) {//(행, 행열크기)
		//0~N행까지 돌면 정답++
		if(start == N) {
			count++;
			return;
		}
		//열 돌면서 행 체크
		for(int y = 0; y<N; y++) {
			boolean visited = true; //해당 열 방문 체크((start, y)에 퀸을 놓았다)
			for(int x = 0; x<start; x++) {
				//위에서 놓은 퀸과 같은 열, 오른아래 대각선, 왼아래 대각선을 지나기에 퀸을 놓을 수 없음(행 차이만큼 열 +-하면 해당 행의 대각선임)
				if(col[x] == y || col[x]+(start-x) == y || col[x]-(start-x) == y) {
					visited = false; //이 행에는 방문하지 않음
					break; //해당 행 다음 열에 다시 퀸을 놓는다
				}
			}
			if(visited) {//방문을 했다면
				col[start] = y;
				dfs(start+1, N);
			}
		}
	}
}
