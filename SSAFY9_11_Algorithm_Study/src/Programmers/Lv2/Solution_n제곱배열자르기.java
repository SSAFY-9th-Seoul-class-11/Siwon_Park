package Programmers.Lv2;

public class Solution_n제곱배열자르기 {
	public int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left + 1)];
        int idx = 0;
        for(long i=left;i<right+1;i++){
            answer[idx++] = (int)(Math.max(i/n,i%n) + 1);
        }
        return answer;
    }
}
