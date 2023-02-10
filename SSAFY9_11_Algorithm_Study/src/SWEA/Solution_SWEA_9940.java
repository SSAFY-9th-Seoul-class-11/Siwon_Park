package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());//테스트 케이스 수
		
		for(int tc = 1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine()); //정수의 개수 N
			boolean[] num = new boolean[N+1]; //인덱스에 해당하는 수열의 숫자가 있는지 확인할 불린 배열
			String output = " Yes"; //yes나 no 출력할 string 변수
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//N개의 숫자 입력하여 있으면 ture!
			for(int i = 1; i<=N; i++) {
				int a = Integer.parseInt(st.nextToken());
				num[a] = true;
			}
			for(int i =1; i<=N; i++) {
				if(!num[i]) output = " No";
			}
			System.out.println("#" + tc + output);
			//bw.write("#" + tc + output + "\n");
		}
	}
}

//메모리, 실생시간 적은데 runtime error...
//public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int TC = Integer.parseInt(br.readLine());//테스트 케이스 수
//     
//    for(int tc = 1; tc<=TC; tc++) {
//        N = Integer.parseInt(br.readLine()); //정수의 개수 N
//        List<Integer> num = new ArrayList<>(); //수열 담을 리스트
//        String output = " Yes"; //yes나 no 출력할 string 변수
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        //N개의 배열 입력받기
//        for(int i = 0; i<N; i++) {
//            int a = Integer.parseInt(st.nextToken());
//            if(num.contains(a)) {
//                output = " No";
//                break;
//            }else {
//                num.add(a);
//            }
//        }
//        System.out.println("#" + tc + output);
//        br.close();
//    }
//}