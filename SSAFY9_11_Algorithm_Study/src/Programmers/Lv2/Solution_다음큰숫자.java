package Programmers.Lv2;

public class Solution_다음큰숫자 {
	public int solution(int n) {
        int answer = n;
        
        int onecnt = Integer.bitCount(n); //bitCount(): 정수를 이진수로 변환한 숫자에서 1을 세줌

        while(true) {
        	answer++;
        	if(Integer.bitCount(answer)==onecnt) break;
        }
        return answer;
    }
}
