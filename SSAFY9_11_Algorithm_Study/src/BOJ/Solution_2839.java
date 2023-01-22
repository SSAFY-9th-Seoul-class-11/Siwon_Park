package BOJ;

import java.util.Scanner;

public class Solution_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int bag = 0;
		
		while(true) {
			if(N%5 == 0) {
				bag += N/5;
				System.out.println(bag);
				break;
			}else {
				N -= 3;
				bag++;
			}
			if(N<0) {
				System.out.println(-1);
				break;
			}
		}
		
	}

}
