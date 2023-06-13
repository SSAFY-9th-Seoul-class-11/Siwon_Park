package Programmers.Lv2;

public class Solution_예상대진표 {
	public int solution(int n, int a, int b)
    {
        int answer = 0;
        for(int i = 1; i<=20; i++){
            if(Math.abs(a-b)==1&&Math.min(a,b)%2==1){
                answer = i;
                break;
            }
            a = (a-1)/2+1;
            b = (b-1)/2+1;
        }
        return answer;
    }
}
