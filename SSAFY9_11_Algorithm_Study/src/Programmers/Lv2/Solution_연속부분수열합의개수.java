package Programmers.Lv2;
import java.util.*;

public class Solution_연속부분수열합의개수 {
	public int solution(int[] elements) {
        int answer = 0;
        int half = elements.length;
        int[] circle = new int[half*2];
        for(int i = 0; i<half*2; i++){
            circle[i] = elements[i%half];
        }
        int sum;
        Set<Integer> hset = new HashSet<>();
        for(int i = 1; i<=half; i++){ // 수열 길이
            for(int j = 0; j<half; j++){ // 수열 첫번째 인덱스
                sum = 0;
                for(int k = j; k<j+i; k++){ // 합 구하기
                    sum += circle[k];
                }
                hset.add(sum);
            }
        }
        answer = hset.size();
        return answer;
    }
}
