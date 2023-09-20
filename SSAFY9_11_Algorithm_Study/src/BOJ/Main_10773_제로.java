package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int x;
		for(int i = 0; i<K; i++) {
			x = Integer.parseInt(br.readLine());
			if(x==0) stack.pop();
			else stack.add(x);
		}
		long sum = 0;
		for(int s : stack) {
			sum += s;
		}
		System.out.println(sum);
	}
}
