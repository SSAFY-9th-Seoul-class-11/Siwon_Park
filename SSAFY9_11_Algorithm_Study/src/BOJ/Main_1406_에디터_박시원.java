package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1406_에디터_박시원 {

	static String str;
	static int N, M, pos;
	static StringBuilder sb = new StringBuilder();
	static Stack<Character> leftStack, rightStack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		leftStack = new Stack<>();
		rightStack = new Stack<>();
		str = br.readLine();
		N = str.length(); // 문자열 길이
		for(int i = 0; i<N; i++) {
			leftStack.push(str.charAt(i));
		}
		M = Integer.parseInt(br.readLine()); // 명령어 개수
		
		for(int i = 0; i<M; i++) {
			edit(br.readLine());
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		while(!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		
		System.out.println(sb);
	}
	
	public static void edit(String order) {
		char o = order.charAt(0); 
		
		switch(o) {
		case 'L':
			if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
			break;
		case 'D':
			if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
			break;
		case 'B':
			if(!leftStack.isEmpty()) leftStack.pop();
			break;
		case 'P':
			char c = order.charAt(2); // 추가할 문자
			leftStack.push(c);
			break;
		}
	}

}
