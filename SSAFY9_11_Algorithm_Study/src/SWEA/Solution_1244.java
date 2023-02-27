package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1244 {

	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken(); // 숫자판 정보
			int[] board = new int[s.length()];//숫자판
			//입력
			for (int i = 0; i < s.length(); i++) {
				board[i] = s.charAt(i) - '0';
			}
			int N = Integer.parseInt(st.nextToken()); // 교환횟수

			//동일한 숫자를 교환했는지 체크하기 위한 arraylist 배열
			ArrayList<Integer>[] check = new ArrayList[10];
			for (int i = 0; i < check.length; i++) {
				check[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < board.length && N > 0; i++) { // 선택 정렬
				// 0~ 끝 num[i] <-> num[maxIndex]
				int maxIndex = i; // 가장 큰 숫자의 index를 담을 변수
				for (int j = i; j < board.length; j++) { // 최대값 위치 찾기
					if (board[maxIndex] <= board[j]) //최대 숫자가 여러개일때 낮은 자리큰숫자를 MSB와 교환
						maxIndex = j;
				}
				if (board[maxIndex] != board[i]) { //최대 숫자가 MSB까지 숫자와 다를때만 교환
					int temp = board[maxIndex];
					board[maxIndex] = board[i];
					board[i] = temp;
					N--; // 교환 횟수 감소 ((조건 추가 1))

					// [4] 동일한 숫자를 교환했는지 체크하기 위해 기록 후, 같은수를 2개 이상 바꿨을 때, 교환횟수의 감소없이 내림차순 정렬해줌
					// 교환후 최대숫자의 값 : temp, 최대 숫자가 있었던 자리 : maxIndex
					ArrayList<Integer> alNum = check[temp];
					alNum.add(maxIndex);
					if (alNum.size() > 1) { // 동일한 숫자를 2개 이상 바꾼 경우, 교환횟수 감호 없이 정렬
						Collections.sort(alNum); // 저장된 index 를 일단 정렬
						for (int j = 0; j < alNum.size(); j++) {
							int maxI = alNum.get(j);
							for (int k = j; k < alNum.size(); k++) {
								if (board[maxI] < board[alNum.get(k)]) {
									maxI = alNum.get(k);
								}
							}
							// num[maxI] <-> num[alNum.get(j)] 교환
							int tempN = board[alNum.get(j)];
							board[alNum.get(j)] = board[maxI];
							board[maxI] = tempN;
						}
					}
				}
			}
			// Arrays.asList(a) : 배열을 List로 변경해주는 메서드, 객체의 배열만 된다, 기본형 타입의 배열은 안된다.
			//HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(board));
			HashSet<Integer> hs = new HashSet<Integer>();
			//교환 횟수가 남았으면 : 남은횟수 만큼 교환해야함
			// 짝수만큼 남은 건 무시, 홀수만큼 남으면 1회 교환(LSB를 바꾸자) 321 4
			if (N % 2 == 1 && hs.size() == board.length) { // [3-1] 456789 10 => 987645
				//같은 숫자가 2개이상 있는경우는 남은 교환 횟수를 무시
				int temp = board[board.length - 1];
				board[board.length - 1] = board[board.length - 2];
				board[board.length - 2] = temp;
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < board.length; i++) {
				System.out.print(board[i]);
			}
			System.out.println();

		}
	}

//	static int[] board;
//	static int change;
//	static int result;
//	static boolean plus;
//	
//	public static void main(String[] args) throws IOException{
//		//Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		//테스트케이스 수
//		int T = Integer.parseInt(br.readLine());
//
//		for(int tc = 1; tc<=T; tc++) {
//			StringTokenizer st = new StringTokenizer (br.readLine(), " ");
//			String s = st.nextToken();//숫자판 정보
//			change = Integer.parseInt(st.nextToken());//교환 횟수
//
//			//숫자판 배열로 만들기
//			board = new int[s.length()]; 
//			for(int i=0; i<s.length(); i++) {
//				board[i] = s.charAt(i) - '0';
//			}
//			result = 0;
//			
//			DFS(0, 0);
//
////			int x = 1;
////			for(int i = s.length()-1; i>=0; i--) {
////				result += board[i]*x;
////				x *= 10;
////			}
//			
//			System.out.println("#" + tc + " " + result);
//		}
//		
//	}
//	public static int num() {
//		int x = 1;
//		for(int i = board.length-1; i>=0; i--) {
//			result += board[i]*x;
//			x *= 10;
//		}
//		return result;
//	}
//	
//	public static void DFS(int start, int count) {
//		if(count == change) {
//			result = Math.max(result, num());
//			return;
//		}
//
//
//		//선택 정렬로 숫자판 교환하기
//		for(int i = start; i<board.length-1; i++) {
//			int maxIdx = start;//가장 큰 숫자의 인덱스
//			for(int j = i+1; j<board.length; j++) {
//				if(board[maxIdx]<board[j]) {
//					maxIdx = j;
//				}
//			}
//
//			if(maxIdx == start) {
//				DFS(start+1, count);
//				continue;
//			}
//			//바꾸기
//			int temp = board[i];
//			board[i] = board[maxIdx];
//			board[maxIdx] = temp;
//			
//			DFS(start+1, count+1);
//
//			
//		}
//
//		return;
//	}

}
