package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2458_키순서_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] arr = new boolean[N+1][N+1]; //연결 확인만 하면 되므로 boolean으로 만들었다
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = true; //입력으로 알 수 있는 연결되어있는 학생들
		}
		//플로이드 워셜 알고리즘
		for(int k = 1; k<=N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(arr[i][k] && arr[k][j]) arr[i][j] = true; //경유로 알 수 있는 연결 학생들
				}
			}
		}
		int result = 0;
		for(int i = 1; i<=N; i++) {
			int cnt = 0; //연결 수
			for(int j = 1; j<=N; j++) {
				if(arr[i][j] || arr[j][i]) cnt++; //경로가 존재한다면 cnt++
			}
			if(cnt == N-1) result++;
		}
		System.out.println(result);
	}
}
