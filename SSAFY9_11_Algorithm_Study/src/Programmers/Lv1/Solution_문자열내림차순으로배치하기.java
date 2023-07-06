package Programmers.Lv1;
import java.util.*;
public class Solution_문자열내림차순으로배치하기 {
	public String solution(String s) {
        String answer = "";
        char[] c = new char[s.length()];
        c = s.toCharArray();
        Arrays.sort(c);
        for(int i = s.length()-1; i>=0; i--){
            answer+=c[i];
        }
        return answer;
    }
}
