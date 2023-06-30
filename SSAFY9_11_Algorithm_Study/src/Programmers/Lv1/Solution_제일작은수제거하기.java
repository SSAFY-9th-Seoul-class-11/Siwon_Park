package Programmers.Lv1;
import java.util.*;

public class Solution_제일작은수제거하기 {
	public int[] solution(int[] arr) {
        int[] answer = {-1};
        if(arr.length==1) return answer;
        
        int minIdx = 0;
        for(int i = 1; i<arr.length; i++){
            if(Math.min(arr[minIdx], arr[i])==arr[i]) {
            	minIdx = i;
            }
        }
        
    	answer = new int[arr.length-1];
    	int idx = 0;
    	for(int i = 0; i<arr.length; i++) {
        	if(i==minIdx)continue;
        	answer[idx] = arr[i];
        	idx++;
        }
        
        return answer;
    }
}
