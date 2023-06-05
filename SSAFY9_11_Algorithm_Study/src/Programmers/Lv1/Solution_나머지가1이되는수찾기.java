package Programmers.Lv1;

public class Solution_나머지가1이되는수찾기 {
	public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<n; i++){
            if(n%i==1){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
