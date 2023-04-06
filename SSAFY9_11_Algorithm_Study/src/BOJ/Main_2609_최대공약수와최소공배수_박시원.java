package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수_박시원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int r = 1;
		
		int a = Math.max(x, y);
		int b = Math.min(x, y);
		
		//최대공약수 구하자(유클리드호제법)
		while(r>0) {
			r = a%b;
			if(r != 0) {
				a = b;
				b = r;
			}
		}
		System.out.println(b);
		System.out.println(x*y/b);
	}
}
