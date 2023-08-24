package Programmers.Lv1;

public class Solution_기사단원의무기 {
	public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i<=number; i++){
            int ysCnt = 0;
            for(int j = 1; j*j<=i; j++){
                if(j*j==i) ysCnt++;
                else if(i%j==0) ysCnt += 2;                
            }
            if(ysCnt>limit) ysCnt = power;
            answer += ysCnt;
        }
        return answer;
    }
}
