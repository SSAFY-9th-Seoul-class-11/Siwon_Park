package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2960_에라토스테네스의채 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N보다 작거나 같은 모든 소수 찾자
		int K = Integer.parseInt(st.nextToken()); // K번째 지우는 수
		int[] arr = new int[N+1];
		for(int i = 2; i<=N; i++) {
			arr[i] = i;
		}
		int cnt = 0;
		for(int i = 2; i<=N; i++) {
			if(arr[i]==0) continue;
			for(int j = i; j<=N; j+=i) {
				if(arr[j]==0) continue;
				arr[j] = 0;
				cnt++;
				if(cnt==K) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}
