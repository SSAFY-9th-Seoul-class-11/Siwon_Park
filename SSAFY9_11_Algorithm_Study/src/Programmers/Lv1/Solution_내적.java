package Programmers.Lv1;

public class Solution_내적 {
	public long solution(int[] a, int[] b) {
        long answer = 0;
        for(int i = 0; i<a.length; i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}
