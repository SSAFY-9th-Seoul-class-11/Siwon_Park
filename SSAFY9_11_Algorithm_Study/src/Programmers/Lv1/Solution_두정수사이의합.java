package Programmers.Lv1;

public class Solution_두정수사이의합 {
	public long solution(int a, int b) {
        long answer = 0;
        int temp = 0;
        if(a>b) {
            temp = a; a = b; b = temp; 
        }
        for(int i = a; i<=b; i++){
            answer += i;
        }
        return answer;
    }
}
