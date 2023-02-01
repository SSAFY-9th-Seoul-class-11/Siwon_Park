package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SWEA_1244 {

	static int[] board;
	static int change;
	static int result;
	static boolean plus;
	
	public static void main(String[] args) throws IOException{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 수
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer (br.readLine(), " ");
			String s = st.nextToken();//숫자판 정보
			change = Integer.parseInt(st.nextToken());//교환 횟수

			//숫자판 배열로 만들기
			board = new int[s.length()]; 
			for(int i=0; i<s.length(); i++) {
				board[i] = s.charAt(i) - '0';
			}
			result = 0;
			
			DFS(0, 0);

//			int x = 1;
//			for(int i = s.length()-1; i>=0; i--) {
//				result += board[i]*x;
//				x *= 10;
//			}
			
			System.out.println("#" + tc + " " + result);
		}
		
	}
	public static int num() {
		int x = 1;
		for(int i = board.length-1; i>=0; i--) {
			result += board[i]*x;
			x *= 10;
		}
		return result;
	}
	
	public static void DFS(int start, int count) {
		if(count == change) {
			result = Math.max(result, num());
			return;
		}


		//선택 정렬로 숫자판 교환하기
		for(int i = start; i<board.length-1; i++) {
			int maxIdx = start;//가장 큰 숫자의 인덱스
			for(int j = i+1; j<board.length; j++) {
				if(board[maxIdx]<board[j]) {
					maxIdx = j;
				}
			}

			if(maxIdx == start) {
				DFS(start+1, count);
				continue;
			}
			//바꾸기
			int temp = board[i];
			board[i] = board[maxIdx];
			board[maxIdx] = temp;
			
			DFS(start+1, count+1);

			
		}

		return;
	}
	

}
