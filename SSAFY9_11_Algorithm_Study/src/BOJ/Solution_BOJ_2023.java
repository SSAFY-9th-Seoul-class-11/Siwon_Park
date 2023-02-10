package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_2023 {
static int N;//N자리의 숫자
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	//한자리 수 소수들부터 시작!
    	recursion(1,2);
    	recursion(1,3);
    	recursion(1,5);
    	recursion(1,7);
    }
    
    //cnt: 자리 수, num: 소수 판별할 숫자
    public static void recursion(int cnt, int num) {
    	if(cnt == N) {
    		if(sosu(num)) {
    			System.out.println(num);
    			return;
    		}
    	}
    	for(int i = 1; i<10; i++) {
    		if(i%2 == 0 || i == 5) continue;//맨 뒷자리 수가 짝수이거나 5이면 소수 아님
    		if(sosu(num*10 + i)) //몇자리 수던 맨 앞글자는 소수인 2, 3, 7, 9이어야 함으로
    			recursion(cnt+1, num*10+i);
    	}
    }
    
    //소수 판별 함수
    public static boolean sosu(int num) {
    	//수를 2부터 수/2로 나눌 수 있는지 
    	for(int i = 2; i<=num/2; i++) {
    		if(num % i == 0) return false; //나눈 나머지가 0이면 소수 아님
    	}
    	return true; 
    }
}
