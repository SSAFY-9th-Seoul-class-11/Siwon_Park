package Programmers.Lv2;

import java.util.Arrays;

public class Solution_구명보트 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int size = people.length;
        int pivot = size-1;
        
        for(int i = 0; i<size; i++){
            for(int j = pivot; j>i; j--){
                if(people[i]+people[j]<=limit){
                    people[i] = 0;
                    people[j] = 0;
                    answer++;
                    pivot = j-1;
                    break;
                }        
            }
            if(pivot<=i) break;
        }
        for(int i = 0; i<size; i++){
            if(people[i] != 0){
                answer++;
            }
        }
        return answer;
    }
}
