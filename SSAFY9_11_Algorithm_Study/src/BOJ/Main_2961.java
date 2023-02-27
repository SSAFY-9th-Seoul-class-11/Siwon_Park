package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {
	static int N;//N개의 재료
	static int[] S;//신맛 배열(곱)
	static int[] B;//쓴맛 배열(합)
	static boolean[] isSelected; // 각 원소가 부분집합의 구성에 포함되었는지 여부
	static int totalCnt;
	static int result = Integer.MAX_VALUE;//쓴맛과 단맛의 차를 최대수로 초기화
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //N개의 재료
		S = new int[N];//신맛 배열
		B = new int[N];//쓴맛 배열
		isSelected = new boolean[N];
		//입력 받기
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		compare(0);
		System.out.println(result);
	}
	
	public static void compare(int idx) {
		if(idx == N) {
			int sin = 1;
			int bit = 0;
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				if(isSelected[i]) {
					cnt++;
					sin *= S[i];
					bit += B[i];
				}	
			}
			if(cnt == 0) return;
			if(result>Math.abs(sin-bit)) {
				result = Math.abs(sin-bit);
			}
			return;
			
		}

		isSelected[idx] = true;
		compare(idx+1);
		isSelected[idx] = false;
		compare(idx+1);
	}

}
