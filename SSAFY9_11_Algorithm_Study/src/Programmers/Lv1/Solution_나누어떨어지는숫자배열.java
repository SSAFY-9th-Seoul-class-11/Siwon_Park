package Programmers.Lv1;
import java.util.*;

public class Solution_나누어떨어지는숫자배열 {
	public int[] solution(int[] arr, int divisor) {
        int[] answer = {-1};
        int size = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                size++;
            }
        }
        if(size!=0){
            answer = new int[size];
            int idx = 0;
            for(int i = 0; i<arr.length; i++){
                if(arr[i]%divisor==0) {
                    answer[idx] = arr[i];
                    idx++;
                }
            }
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
