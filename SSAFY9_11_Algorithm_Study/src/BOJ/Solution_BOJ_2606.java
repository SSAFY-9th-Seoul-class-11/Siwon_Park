package BOJ;

import java.util.Scanner;

public class Solution_BOJ_2606 {
	
	public static int c;
	public static int ssang;
	public static int[][] group;//배열 만들어서 각 컴퓨터끼리 연결되어있는지 표시(1번 컴퓨터부터 시작이므로 0은 비움)
	public static boolean[] visited;//방문 체크
	public static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		c = sc.nextInt();//컴퓨터 수(노드 수)
		ssang = sc.nextInt();//직접 연결되어 있는 컴퓨터 쌍의 수(라인 수)
		
		group = new int[c+1][c+1];
		visited = new boolean[c+1];
		
		for(int i = 0; i<ssang; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			group[a][b] = group[b][a] = 1;
		}
		
		

	}
	public static void dfs(int start) {
		visited [start] = true;
		count++;
		
		for(int i = 0 ; i <= c ; i++) {
			if(group[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}

}
