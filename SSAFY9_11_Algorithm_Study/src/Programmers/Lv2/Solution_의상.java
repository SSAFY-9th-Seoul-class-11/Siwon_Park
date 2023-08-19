package Programmers.Lv2;
import java.util.*;

public class Solution_의상 {
	public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cmap = new HashMap<>();
        for(int i = 0; i<clothes.length; i++){
            cmap.put(clothes[i][1], cmap.getOrDefault(clothes[i][1], 1)+1);
        }
        for(String key : cmap.keySet()){
            answer *= cmap.get(key);
        }
        return answer-1;
    }
}
