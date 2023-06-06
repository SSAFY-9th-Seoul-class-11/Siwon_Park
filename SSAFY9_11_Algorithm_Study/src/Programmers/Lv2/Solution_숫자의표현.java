package Programmers.Lv2;

public class Solution_숫자의표현 {
	public int solution(int n) {
        int answer = 0;
        int sum = 0;
        for(int i = 1; i<=n; i++){
            sum = 0;
            for(int j = i; j<=n; j++){
                sum+=j;
                if(sum>=n){
                    break;
                }
            }
            if(sum==n){
                answer++;
            }
        }
        return answer;
    }
}
