package Programmers.Lv1;
import java.util.*;

public class Solution_과일장수 {
	public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int idx = score.length-m;
        while(idx>=0){
            answer += score[idx];
            idx -= m;
        }
        answer *= m;
        return answer;
    }
}
