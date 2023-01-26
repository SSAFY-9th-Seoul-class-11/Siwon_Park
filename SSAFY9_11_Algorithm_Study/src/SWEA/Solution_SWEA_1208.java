package SWEA;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<10; i++) {
			//덤프 수 입력
			int dump = sc.nextInt();
			//박스 입력받기
			int[] box = new int[100];
			for(int j = 0; j<100; j++) {
				box[j] = sc.nextInt();
			}
			//오름차순으로 정렬
			Arrays.sort(box);
			//젤 많은 곳에서 젤 적은 곳으로 박스 옮기고 다시 정렬
			for(int k = 0; k<dump; k++) {
				box[99]--;
				box[0]++;
				Arrays.sort(box);
				//박스 차이가 1이하면 stop
				if(box[99]-box[0] <= 1) break;
			}
			System.out.println("#" + (i+1) + " " + (box[99]-box[0]));
		}

	}

}
