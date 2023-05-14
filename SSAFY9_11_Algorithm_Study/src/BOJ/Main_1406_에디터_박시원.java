package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1406_에디터_박시원 {

	static String str;
	static int N, M, pos;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb.append(br.readLine()); //초기 입력 문자열
		N = sb.length(); // 문자열 길이
		M = Integer.parseInt(br.readLine()); // 명령어 개수
		pos = N; //커서 위치 (초기에는 문장의 맨 뒤)
		
		for(int i = 0; i<M; i++) {
			edit(br.readLine());
		}
		
		System.out.println(sb);
	}
	
	public static void edit(String order) {
		char o = order.charAt(0); 
		
		switch(o) {
		case 'L':
			if(pos != 0) pos--;
			break;
		case 'D':
			if(pos != N) pos++;
			break;
		case 'B':
			if(pos != 0) {
				sb.deleteCharAt(pos-1);
				pos--; N--;
			}
			break;
		case 'P':
			char c = order.charAt(2); // 추가할 문자
			sb.insert(pos, c);
			pos++; N++;
			break;
		default:
			break;
		}
	}

}
