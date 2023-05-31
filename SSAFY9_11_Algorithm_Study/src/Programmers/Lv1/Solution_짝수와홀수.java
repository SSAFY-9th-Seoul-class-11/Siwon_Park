package Programmers.Lv1;

public class Solution_짝수와홀수 {
	public String solution(int num) {
		String answer = "";
		if (num % 2 == 0) {
			answer = "Even";
		} else {
			answer = "Odd";
		}

		return answer;
	}
}
