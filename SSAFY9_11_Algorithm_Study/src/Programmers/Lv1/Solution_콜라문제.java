package Programmers.Lv1;

public class Solution_콜라문제 {
	public int solution(int a, int b, int n) {
        if(n<a) return 0;
        int answer = 0;
        while(n>=a){
            answer += (n/a*b);
            n = n/a*b + n%a;   
        }
        return answer;
    }
}
