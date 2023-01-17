package Programmers.Lv3;

import java.util.Arrays;

public class BestSet {

	public int[] solution(int n, int s) {
		
		//s를 n개의 자연수의 합으로 표현해야 하므로 n>s일 때 표현할 수 없으므로 [-1]리턴 
		if(n>s) return new int[] {-1};
					
		int[] answer = new int[n];
		//각각의 원소가 가장 크면 곱이 최대이므로 s를 n으로 나눈 몫+ 나머지를 나눠 넣는다
		for(int i = 0; i<n; i++) {
			answer[i] = s/n;
		}
		for(int i = 0; i<s%n; i++) {
			answer[i]++;
		}
		//배열 원소 오름차순으로 정렬
		Arrays.sort(answer);
        return answer;
	}

}
