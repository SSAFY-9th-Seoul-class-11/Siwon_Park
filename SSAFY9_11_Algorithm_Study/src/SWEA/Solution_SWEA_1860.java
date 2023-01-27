package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1860 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			//N명의 사람들, M초의 시간동안 K개의 붕어빵 만듦
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			//N명의 사람들이 언제 도착하는지
			int[] guestTime = new int[N];
			for(int i = 0; i<N; i++) {
				guestTime[i] = sc.nextInt();
			}
			Arrays.sort(guestTime);//시간순으로 정렬
			
			boolean get = true; //붕어빵을 가져갔는지
			int count = 0;//붕어빵 개수
			
			//가장 늦게오는 손님 올 때까지
			for(int time = 0; time<=guestTime[N-1]; time++) {
				//시간이 M만큼 흘러가면 붕어빵 K개 생김
				if(time%M == 0 && time!=0) {
					count += K;
				}
				//손님이 올 시간이 됐는데 
				for(int i = 0; i<N; i++) {
					if(time == guestTime[i]) {
						if(count>0) {
							count--;//붕어빵이 있다면 하나 빼주고
						}else {
							get = false;//없다면 false
						}
					}
				}
				//붕어빵 못받은 사람이 있거나 사람보다 붕어빵이 많아지면 탈출
				if(get == false || count>=N) break;
			}
			if(get == true) {
				System.out.println("#" + tc + " Possible");
			}else {
				System.out.println("#" + tc + " Impossible");
			}

		}
		
	}
}
