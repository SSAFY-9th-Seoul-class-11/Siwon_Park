package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_2992 {
	static int X;
	static int[] x;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		int size = String.valueOf(X).length();//숫자 길이
		x = new int[size];
		int p = X;
		for(int i = 0; i<size; i++) {
			x[i] = p%10;//0~size 까지 1의자리수부터 넣는다
			p = p/10;
			//System.out.println(i+ "의 자리 수 : " + x[i]);
		}
		Arrays.sort(x);

		boolean isMax = true;//X가 가장 큰 수인지 확인
		do {
			String result = "";
			for(int i = 0; i<size; i++) {
				result = result + String.valueOf(x[i]);
			}
			if(Integer.parseInt(result)>X) {
				isMax = false;
				System.out.println(result);
				break;
			}
		}while(np(x));
		if(isMax) System.out.println(0);

	}
	private static boolean np(int[] input) {
		int n = input.length;
		
		//step1. 뒤쪽부터 꼭대기를 찾는다.(꼭대기 바로 앞이 교환할 자리)
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i == 0) return false;
		
		//step2. 꼭대기 바로 앞(i-1)자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n-1;
		while(input[i-1]>=input[j]) --j;
		
		//step3. 꼭대기 바로 앞(i-1) 자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
		swap(input, i-1, j);
		
		//step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n-1;
		while(i<k) {
			swap(input, i++, k--);
		}		
		return true;
	}
	
	private static void swap(int[] input, int i , int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
