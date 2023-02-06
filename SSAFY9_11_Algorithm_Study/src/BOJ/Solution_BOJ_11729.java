package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_11729 {
	
	static int N;//N개의 원판
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		sb.append((int)Math.pow(2, N)-1 + "\n");//2^N-1번 옮김
		hanoiTower(N, 1, 3);//N개의 고리를 1에서 3으로 옮기자!
		System.out.println(sb);
	}

	public static void hanoiTower(int n, int start, int end) {
		if(n == 1) {
			sb.append(start+ " " + end + "\n");
			return;
		}
		
		hanoiTower(n-1, start, 6-start-end);//n-1개를 start에서 나머지 막대로 옮김
		sb.append(start+ " " + end + "\n");//n번째 고리를 start에서 end로 옮김
		hanoiTower(n-1, 6-start-end, end);//나머지 막대로 옮겨둔 n-1개를 end로 옮김
	}
	
}
