package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭발_박시원 {
	static char[] bomb;
	static Stack<Character> st = new Stack<>();
	static Stack<Character> st2 = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i = 0; i<s.length(); i++) {
			st.add(s.charAt(i));
		}

		s = br.readLine();
		bomb = new char[s.length()];
		for(int i = 0; i<s.length(); i++) {
			bomb[i] = s.charAt(i);
		}

		int size = st.size();
		for(int i = 0; i<size; i++) {
			boolean flag = false;
			char c = st.peek();
			for(int j = 0; j<bomb.length; j++) {
				if(c == bomb[j]) flag = true;
			}
			if(flag) st.pop();
			else st2.add(st.pop());
		}
		StringBuilder sb = new StringBuilder();
		size = st2.size();
		for(int i = 0; i<size; i++) {
			sb.append(st2.pop());
		}
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
	}
}
