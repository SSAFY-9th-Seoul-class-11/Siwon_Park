package Programmers.Lv1;

public class Solution_수박수박수박수박수박수 {
	public String solution(int n) {
        String answer = "";
        for(int i = 0; i<n; i++){
            if(i%2==0){
                answer += "수";
            }else{
                answer += "박";
            }
        }
        return answer;
    }
}
