package Programmers.Lv1;
import java.util.*;
public class Solution_실패율 {
	public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        Map<Integer, Double> map = new HashMap<>();
        int[] stagePNum = new int[N+1];
        // double[] percent = new double[N+1];
        int idx = 1;
        int pCnt = stages.length;
        for(int i = 0; i<stages.length; i++){
            if(stages[i]<idx) {
                pCnt -= stagePNum[idx];
                map.put(idx, ((double)stagePNum[idx])/((double)pCnt));
                // percent[idx] = ;
                idx = stages[i];
            }
            if(stages[i]==idx) stagePNum[idx]++;
        }
        int[] answer = new int[N];
    for (int i = 0; i < N; i++) {
        double max = -1;
        int rKey = 0;
        for (int key : map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
                rKey = key;
            }
        }
        answer[i] = rKey;
        map.remove(rKey);
    }
        return answer;
    }
}
