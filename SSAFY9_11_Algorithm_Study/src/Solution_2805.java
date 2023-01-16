import java.util.Scanner;

public class Solution_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int sum = 0;
			
			//0~n/2행 계산
			for(int i = N/2; i>=0; i--) {
				String farm = sc.next();//각 행의 농장 작물 수 입력
				for(int j = i; j<=N-1-i; j++) {
					sum += farm.charAt(j)-'0';//charAt()-'0'으로 int형변환
				}
			}
			
			//n/2+1~n-1행 계산
			for(int i = 1; i<=N/2; i++) {
				String farm = sc.next();
				for(int j = i; j<=N-1-i; j++) {
					sum += farm.charAt(j)-'0';
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}

	}

}
