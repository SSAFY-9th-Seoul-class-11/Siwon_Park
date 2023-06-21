package Programmers.Lv1;
import java.util.*;

public class Solution_정수내림차순으로배치하기 {
	public long solution(long n) {
        long answer = 0;
        int size = Long.toString(n).length();
        int[] num = new int[size];
        for(int i = 0; i<size; i++){
            num[i] = (int)(n%10);
            n/=10;
        }
        Arrays.sort(num);
        for(int i  = 0; i<size; i++){
            answer += num[size-1-i];
            answer *= 10;
        }
        answer/=10;
        return answer;
    }
}
