package BOJ;

import java.util.Scanner;

public class Solution_BOJ_2606 {
	
	public static int c;//컴퓨터 수(노드 수)
	public static int link;//직접 연결되어 있는 컴퓨터 쌍의 수(라인 수)
	public static int[][] group;//배열 만들어서 각 컴퓨터끼리 연결되어있는지 표시(1번 컴퓨터부터 시작이므로 0은 비움)
	public static boolean[] visited;//방문 체크
	public static int count;//1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		c = sc.nextInt();
		link = sc.nextInt();
		
		group = new int[c+1][c+1];
		visited = new boolean[c+1];
		
		//번호 쌍의 각각의 배열에 1을 넣어준다
		for(int i = 0; i<link; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			group[a][b] = group[b][a] = 1;
		}
		count = 0;
		dfs(1);
		System.out.println(count-1);//1번 컴퓨터는 빼고!
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
