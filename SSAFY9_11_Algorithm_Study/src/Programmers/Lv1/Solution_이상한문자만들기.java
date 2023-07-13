package Programmers.Lv1;
import java.util.*;

public class Solution_이상한문자만들기 {
	public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int idx = 0;
        
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(" ")) {
            	answer+=" ";
                idx = 0;
                continue;
            }
            
            answer += idx % 2 == 0 ? str[i].toUpperCase() : str[i].toLowerCase();
            idx++;
        }
        
        return answer;
    }
}
