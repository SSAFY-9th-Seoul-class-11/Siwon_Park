package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수_박시원 {

	static int N, zero, one;
	static int[][] fibonacci;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine()); //fibonacci(N)을 호출할거임
			
			if(N == 0) {zero = 1; one = 0;}
			else if(N == 1) {zero = 0; one = 1;}
			else {
				fibonacci = new int[N+1][2]; //[i][0]은  fibonacci(i)의 0 개수
				fibonacci[0][0] = 1; fibonacci[0][1] = 0; //fibonacci(0)은 0이기에 0이 하나, 1이 0개이다
				fibonacci[1][0] = 0; fibonacci[1][1] = 1; //fibonacci(1)은 1이기에 0이 0, 1이 1이다
				zero = 0; one = 0;
				fibonacci();
			}
			System.out.println(zero + " " + one);
		}
	}
	
	public static void fibonacci() {
		for(int i = 2; i<=N; i++) {
			fibonacci[i][0] = fibonacci[i-1][0] + fibonacci[i-2][0];
			fibonacci[i][1] = fibonacci[i-1][1] + fibonacci[i-2][1];
		}
		zero = fibonacci[N][0];
		one = fibonacci[N][1];		
	}

}
