package Programmers.Lv1;

public class Solution_문자열다루기기본 {
	public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4||s.length()==6){
            char[] c = s.toCharArray();
            for(int i = 0; i<s.length(); i++){
                if(c[i]-'0'<0||c[i]-'0'>9){
                    answer = false;
                    break;
                }
            }
        }else{
            answer = false;
        }
        return answer;
    }
}
