package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1449 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();// 물 새는 곳 개수
		int L = sc.nextInt();// 테이프 길이
		
		int[] pos = new int[N];//물 새는 곳의 위치
		for(int i = 0; i<N; i++) {
			pos[i] = sc.nextInt();
		}
		Arrays.sort(pos);//물 새는 곳 정렬
		
		int count = 0;//테이프 개수
		int tape = 0;//테이프가 마지막으로 커버한 위치
		for(int i = 0; i<N; i++) {
			//물 새는 위치가 테이프 위치 보다 크다면
            if (pos[i] > tape) {
                tape = pos[i] + L - 1;//새 테이프 붙임! 최대한 큰 쪽까지 닿도록
                count++;
            }
		}
		System.out.print(count);
	}
}
