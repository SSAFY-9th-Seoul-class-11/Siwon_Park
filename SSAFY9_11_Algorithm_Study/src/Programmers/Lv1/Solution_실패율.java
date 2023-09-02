package Programmers.Lv1;
import java.util.*;
public class Solution_실패율 {
	public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>();
        int[] pFailCnts = new int[N+2];
        int[] pTotalCnts = new int[N+1];
        
        for(int stage : stages){
            pFailCnts[stage]++;
        }
        
        pTotalCnts[N] = pFailCnts[N]+pFailCnts[N+1];
        for(int i = N-1; i>=1; i--){
            pTotalCnts[i] = pFailCnts[i]+pTotalCnts[i+1];
        }
        
        for(int i = 1; i<pTotalCnts.length; i++){
            if(pFailCnts[i]==0 || pTotalCnts[i]==0) map.put(i, 0.0);
            else map.put(i, (double)pFailCnts[i]/pTotalCnts[i]);
        }
                         
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
