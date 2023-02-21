package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_BOJ_2565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전깃줄 개수
        int[][] num = new int[n + 1][2]; //[][0] : A 전깃줄 번호, [][1] : B 전깃줄 번호
        int[] dp = new int[n + 1]; // 해당 위치까지의 가장 많이 설치할 수 있는 전깃줄 개수
        int max = 1; //가장 많이 설치할 수 있는 개수
        
        for (int i = 1; i <= n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<2; j++) {
        		num[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        Arrays.sort(num, new Comparator<int[]>() { //A전봇대[][0] 기준으로 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //인덱스가 i보다 작은 경우, 해당 인덱스의 배열 값(B)이 i 인덱스의 배열 값(A)보다 작아야한다
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (num[i][1] > num[j][1]) { // 이전의 A들의 전깃줄과 이어진 B의 번호보다 현재 B 번호가 더 커야 이을 수 있다.
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 이전의 최대 전깃줄 개수+1
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max); //전체 개수 - 최대 설치 가능 개수 = 최소 제거 개수
    }

}
