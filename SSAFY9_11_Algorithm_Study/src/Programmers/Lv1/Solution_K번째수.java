package Programmers.Lv1;
import java.util.*;

public class Solution_K번째수 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] arr;
        int idx;

        for(int i = 0; i<commands.length; i++){
            arr = new int[commands[i][1]-commands[i][0]+1];
            idx = 0;
            for(int j = commands[i][0]-1; j<commands[i][1]; j++){
                arr[idx++] = array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        
        return answer;
    }
}
