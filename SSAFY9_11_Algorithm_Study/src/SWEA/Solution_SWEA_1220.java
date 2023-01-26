package SWEA;

import java.util.Scanner;

public class Solution_SWEA_1220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10개의 테스트케이스
		for(int tc = 1; tc<=10; tc++) {
			//한 변의 길이 100 입력받기
			int loo = sc.nextInt();
			//테이블 선언, 초기화, 입력받기
			int[][] table = new int[100][100];
			for(int i = 0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			//교착상태 카운트
			int count = 0; 
			//1-N, 2-S / 위N, 아래S : 1은 아래로 내려가고, 2는 위로 올라간다
			//자성체 탐색 시작 / 한 열 기준, 2가 나왔는데, 직전 위에 1이 있으면 교착상태하나
			for(int j = 0; j<100; j++) {
				boolean one = false;//전 행에 1이 있었는지 확인
				for(int i = 0; i<100; i++) {
					if(table[i][j] == 1) {
						one = true;
					}
					if(table[i][j] == 2 && one) {
						count++;
						one = false;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}

	}

}
