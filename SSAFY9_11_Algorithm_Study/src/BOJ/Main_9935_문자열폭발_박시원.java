package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭발_박시원 {
	static String str;
	static char[] bomb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String s2 = br.readLine();
		bomb = new char[s2.length()];
		for(int i = 0; i<s2.length(); i++) {
			bomb[i] = s2.charAt(i);
		}

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<s.length(); i++) {
			sb.append(s.charAt(i));
			if(sb.length()>=bomb.length) {
				boolean flag = true;
				for(int j = 0; j<bomb.length; j++) {
					if(sb.charAt(sb.length()-bomb.length+j) != bomb[j]) flag = false;
				}
				if(flag) sb.delete(sb.length()-bomb.length, sb.length());
			}
		}
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
	}
}