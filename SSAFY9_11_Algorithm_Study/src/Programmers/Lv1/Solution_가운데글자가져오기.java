package Programmers.Lv1;

public class Solution_가운데글자가져오기 {
	public String solution(String s) {
        String answer = "";
        int size = s.length();
        if(size%2==0){
            answer = s.substring(size/2-1,size/2+1);
        }else{
            answer = s.substring(size/2, size/2+1);
        }
        return answer;
    }
}
