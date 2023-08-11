package Programmers.Lv2;
import java.util.*;

public class Solution_HIndex {
	public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i<citations.length; i++){
            int h = citations.length-i; // h(논문개수)줄이고
            if(h<=citations[i]){ // 인용횟수 늘리면서 처음으로 같거나 많을 때 정답
                answer = h;
                break;
            }
        }
        return answer;
    }
}
