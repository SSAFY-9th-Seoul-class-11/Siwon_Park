package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1065_한수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		if(N<100) cnt = N;
		else if(N<111) cnt = 99;
		else {
			cnt = 99;
			for(int i = 111; i<=N; i++) {
				if(i/100-(i%100)/10==(i%100)/10-i%10) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
