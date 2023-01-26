package SWEA;
import java.util.Scanner;

public class Solution_SWEA_1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//10개의 테스트케이스
		for(int i = 0; i<10; i++) {
			//건물 수 입력
			int N = sc.nextInt();
			//N개의 빌딩 높이 입력받기 
			int[] building = new int[N];
			for(int j = 0; j<N; j++) {
				building[j] = sc.nextInt();
			}
			//조망권 확보 세대 수 초기화
			int count = 0;
			//조망권 확인
			for(int j = 2; j<N-2; j++) {
				//양 옆 4 빌딩중 가장 높은 빌딩
				int high_building = Math.max(Math.max(building[j-2], building[j-1]), Math.max(building[j+1], building[j+2]));
				//building[j]가 양 옆 4 건물보다 높을 때만 진행
				if(building[j]>high_building) {
					count += (building[j]-high_building);
				}
			}
			System.out.println("#" + (i+1) + " " + count);
		}

	}

}
