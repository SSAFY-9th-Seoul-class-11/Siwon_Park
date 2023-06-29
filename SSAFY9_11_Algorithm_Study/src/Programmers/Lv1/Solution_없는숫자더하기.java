package Programmers.Lv1;
import java.util.*;

public class Solution_없는숫자더하기 {

	public int solution(int[] numbers) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(numbers);
        for(int i = 0; i<=9; i++){
            if(numbers.length!=idx && numbers[idx]==i) {
            	idx++;
            	continue;
            }
            answer+=i;
        }
        return answer;
    }

}
