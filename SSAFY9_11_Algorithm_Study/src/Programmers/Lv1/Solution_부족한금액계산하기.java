package Programmers.Lv1;

public class Solution_부족한금액계산하기 {
	public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for(int i = 1; i<=count; i++){
            sum += price*i;
        }
        if(sum-money>0){
            answer += sum-money;
        }

        return answer;
    }
}
