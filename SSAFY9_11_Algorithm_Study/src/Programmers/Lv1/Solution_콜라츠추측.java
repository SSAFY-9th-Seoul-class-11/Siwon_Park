package Programmers.Lv1;

public class Solution_콜라츠추측 {
	public int solution(long num) {
        int answer = 0;
        while(num != 1){
            if(answer>=500){
                answer = -1;
                break;
            }
            if(num%2==0) num/=2;
            else num = num*3+1;
            answer++;
        }
        return answer;
    }
}
