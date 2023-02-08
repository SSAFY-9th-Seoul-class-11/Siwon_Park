package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_9940 {
	static int N; //길이 N의 순열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());//테스트 케이스 수
		
		for(int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine()); //정수의 개수 N
			List<Integer> num = new ArrayList<>(); //수열 담을 리스트
			String output = " Yes"; //yes나 no 출력할 string 변수
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//N개의 배열 입력받기
			for(int i = 0; i<N; i++) {
				int a = Integer.parseInt(st.nextToken());
				if(num.contains(a)) {
					output = " No";
					//break;
				}else {
					num.add(a);
				}
			}
			//br.close();
			System.out.println("#" + tc + output);
		}
	}
}
