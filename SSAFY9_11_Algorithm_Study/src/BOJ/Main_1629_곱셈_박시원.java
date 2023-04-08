package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_곱셈_박시원 {

	static long A, B, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(pow());
		
	}
	
	public static long pow() {
		long res = 1L; 
        A = A % C; 
        
        while (B > 0) {    
            if (B % 2 == 1) res = (res * A) % C; 
            B = B >> 1; 
            A = (A * A) % C; 
        }  
        return res; 
	}
}
