package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1786_찾기_박시원 {
	static ArrayList<Integer> list = new ArrayList<>();
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		
		kmp(T, P);
		System.out.println(cnt);
		for(int i = 0; i<cnt; i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static int[] getPi(String p) {
		int[] pi = new int[p.length()];
		int j = 0;
		for(int i = 1; i<p.length(); i++) {
			while(j>0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) pi[i] = ++j;
		}
		return pi;
	}
	
	public static void kmp(String t, String p) {
		int pi[] = getPi(p);
		int j = 0;

		for(int i = 0; i<t.length(); i++) {
			while(j>0 && t.charAt(i) != p.charAt(j)) j = pi[j-1];
			if(t.charAt(i) == p.charAt(j)) {
				if(j == p.length()-1) {
					++cnt;
					list.add(i-j+1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
	}

}
