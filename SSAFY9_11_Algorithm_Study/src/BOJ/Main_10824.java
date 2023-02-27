package BOJ;

import java.util.Scanner;

public class Main_10824 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = new String[4];
		for(int i = 0; i<4; i++) {
			num[i] = sc.next();
		}
		long ab = Long.parseLong(num[0]+num[1]);
		long cd = Long.parseLong(num[2]+num[3]);
		System.out.println(ab+cd);
	}
}
