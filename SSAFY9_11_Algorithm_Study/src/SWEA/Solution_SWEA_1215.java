package SWEA;

import java.util.Scanner;

public class Solution_SWEA_1215 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10개의 테스트케이스 고정
		for(int tc = 1; tc<=10; tc++) {
			//찾아야 하는 회문의 길이
			int length = sc.nextInt();
			//회문 수
			int count = 0;
			//맵 입력받기
			char[][] map = new char[8][8];
			for(int i = 0; i<8; i++) {
				//한 행씩 입력받기
				String row = sc.next();
				for(int j = 0; j<8; j++) {
					map[i][j] = row.charAt(j);
				}
			}
			
			//가로 회문 수 세기
            for(int i =0; i<8; i++) { //8개 행 돌기
                for(int j=0; j<8-length+1; j++) { //각 행마다 8-length+1번만 확인하면 됨
                    boolean equal = true; //회문 검사 시 일치 검사
                    for(int k=0;k<length/2;k++) { //짝, 홀 상관 없이 length/2번 확인
                        if(map[i][j+k] != map[i][j+length-k-1]) { //같지 않다면 일치 false!
                            equal = false;
                        }
                    }
                    //전부 일치하면 회문수++
                    if(equal == true) {
                        count++;
                    }              
                }
            }
            
            //세로 회문 수 세기
            for(int i =0; i<8-length+1; i++) {
                for(int j=0; j<8; j++) {
                	boolean equal = true;
                    for(int k=0; k<length/2; k++) {
                        if(map[i+k][j] != map[i+length-k-1][j]) {
                        	equal = false;
                        }
                    }
                    if(equal == true) {
                        count++;
                    }
                }
            }
            System.out.println("#" + tc + " " + count);
			
		}
		
	}

}
