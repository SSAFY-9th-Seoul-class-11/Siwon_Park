package Programmers.Lv1;

public class Solution_정수제곱근판별 {
	public long solution(long n) {
        long answer = 0;
        long i = 1;
        while(true){
            if(Math.pow(i,2)>=n){
                if(Math.pow(i,2)==n){
                    answer = (long)(Math.pow(i+1, 2));
                }else{
                    answer = -1;
                }
                break;
            }
            i++;
        }
        return answer;
    }
}
