package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		int num = 1, cnt = 0;
		while(true) {
			S -= num++;
			cnt++;
			if(S<num) break;
		}
		System.out.println(cnt);
	}
}
