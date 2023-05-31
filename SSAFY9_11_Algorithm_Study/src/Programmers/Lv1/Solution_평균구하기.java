package Programmers.Lv1;

public class Solution_평균구하기 {
	public double solution(int[] arr) {
		double answer = 0;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			answer += arr[i];
		}
		answer /= size;
		return answer;
	}
}
