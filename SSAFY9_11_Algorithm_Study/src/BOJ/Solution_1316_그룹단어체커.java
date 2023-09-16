package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_1316_그룹단어체커 {
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		for(int i = 0; i<N; i++) {
			check(br.readLine().toCharArray());
		}
		System.out.println(cnt);
	}
	public static void check(char[] word) {
		ArrayList<Character> arr = new ArrayList<>();
		Set<Character> hset = new HashSet<>();
		for(int i = 0; i<word.length; i++) {
			if(i==0||word[i]!=word[i-1]) arr.add(word[i]);
			hset.add(word[i]);
		}
		if(arr.size()==hset.size())cnt++;
	}
}
