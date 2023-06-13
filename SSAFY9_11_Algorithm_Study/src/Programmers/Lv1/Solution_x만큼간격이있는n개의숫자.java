package Programmers.Lv1;

public class Solution_x만큼간격이있는n개의숫자 {
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long xl = x;
        for(int i = 1; i<=n; i++){
            answer[i-1] = x*i;
        }
        return answer;
    }
}
