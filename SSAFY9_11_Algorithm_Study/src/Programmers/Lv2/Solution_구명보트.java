package Programmers.Lv2;

import java.util.Arrays;

public class Solution_구명보트 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int pivot = 0;
        
        for(int i = people.length-1; i>=pivot; i--){
            if(people[i]+people[pivot]<=limit){
                pivot++;
            }
            answer++;
        }
        return answer;
    }
}
