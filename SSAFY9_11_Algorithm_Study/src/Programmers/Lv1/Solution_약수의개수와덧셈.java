package Programmers.Lv1;

public class Solution_약수의개수와덧셈 {
	public int solution(int left, int right) {
        int answer = 0;
        int sum = 0;
        for(int i = left; i<=right; i++){
            sum = 0;
            for(int j = 1; j<=i; j++){
                if(i%j==0){
                    sum++;
                }
            }
            if(sum%2==0) {
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }
}
