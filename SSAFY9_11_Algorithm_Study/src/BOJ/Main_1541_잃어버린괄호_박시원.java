package BOJ;

import java.util.Scanner;

public class Main_1541_잃어버린괄호_박시원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//받은 입력 -로 나누기
        String[] arr = sc.nextLine().split("-");
        int ans = 0;
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			//+기준으로 나누기
			String[] cal2 = arr[i].split("\\+");
			for(int j=0;j<cal2.length;j++) {
				sum += Integer.parseInt(cal2[j]);
			}
			if(i==0) {
				ans += sum;
			}else {
				ans -= sum;
			}
		}
		System.out.println(ans);
	}

}
