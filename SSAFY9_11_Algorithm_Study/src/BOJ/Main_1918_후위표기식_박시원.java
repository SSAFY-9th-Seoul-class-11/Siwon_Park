package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918_후위표기식_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z') { // 피연산자는 출력
				sb.append(str.charAt(i));
			}else if(str.charAt(i)==')') { // 닫는 괄호 나오면 
				while(stack.peek()!='(') { // 여는 괄호 나올 때까지 연산자 출력
					sb.append(stack.pop());
				}
				stack.pop();
			}else { // ( , +-*/연산자일 때
				// stack에서 peek한 연산자가 현재 연산자보다 우선순위가 더 높으면 
				while(!stack.isEmpty() && Pri(str.charAt(i)) >= 0 && Pri(stack.peek())>=Pri(str.charAt(i))) { // 전부 pop해서 출력
					sb.append(stack.pop());
				}
				stack.push(str.charAt(i));
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
	
	public static int Pri(char c) {
		if(c == '(') return -1;
		if(c == '+' || c == '-') return 0;
		else return 1;
	}

}
