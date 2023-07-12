package Programmers.Lv1;
import java.util.*;

public class Solution_같은숫자는싫어 {
	public int[] solution(int []arr) {
        int size = 1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1]==arr[i]) continue;
            size++;
        }
        int[] answer = new int[size];
        int idx = 0;
        answer[0] = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1]==arr[i]) continue;
            idx++;
            answer[idx] = arr[i];
        }
        return answer;
    }
}
