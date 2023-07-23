package Programmers.Lv1;
import java.util.*;

public class Solution_문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i<strings.length; i++){
            arr.add(strings[i].substring(n, n+1)+strings[i]);
        }
        
        Collections.sort(arr);

        for(int i = 0; i<strings.length; i++){
            answer[i] = arr.get(i).substring(1,arr.get(i).length());
        }
        return answer;
    }
}
