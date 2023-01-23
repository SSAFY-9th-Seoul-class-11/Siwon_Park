package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		for(int tc = 1; tc<=10; tc++) {
			int T = sc.nextInt();
			
			//큐 입력받기
			Queue<Integer> code = new LinkedList<Integer>();
			for(int i = 0; i<8; i++) {
				int c = sc.nextInt();
				code.add(c);
			}
			
			boolean coding = true;
			int c = 0;
			while(coding == true) {
				for(int i = 1; i<=5; i++) {
					c = code.poll();
					c -= i;
					if(c <= 0) {
						c = 0;
						coding = false;
					}
					code.add(c);
				}
			}
			System.out.print("#" + tc +" ");
			for(int i = 0 ; i<8; i++) {
				System.out.print(code.poll() + " ");
			}
			System.out.println();
		}
	}
}


/*
 * queue
 * add() =>큐에 값 추가
 * offer() =>큐에 값 추가
 * poll() =>큐의 첫번째 값을 반환하고 제거, 비어있다면 null 반환
 * remove() =>큐의 첫번재 값 제거
 * clear() =>큐 초기화
 * peek() =>큐 첫번째 값 참조
 * */