package Programmers.Lv1;

public class Solution_푸드파이트대회 {
	public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i<food.length; i++){
            food[i]/=2;
        }
        for(int i = 1; i<food.length; i++){
            for(int j = 0; j<food[i]; j++){
                answer+=i;
            }
        }
        answer+=0;//0 "0" 상관 없음
        for(int i = food.length-1; i>=1; i--){
            for(int j = 0; j<food[i]; j++){
                answer+=i; //String.valueOf(i)로 해도 됨
            }
        }
        return answer;
    }
}
