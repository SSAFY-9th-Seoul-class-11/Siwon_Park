package Programmers.Lv2;

public class Solution_카펫 {
	public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        
        int c = brown+yellow;
        for(int i = 3; i<c/2; i++){
            if(c%i==0){
                if(brown == (i+c/i)*2-4){
                    answer[0] = c/i;
                    answer[1] = i;
                    break;
                }
            }
            
        }
        return answer;
    }
}
