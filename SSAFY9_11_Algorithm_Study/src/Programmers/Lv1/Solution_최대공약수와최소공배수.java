package Programmers.Lv1;
import java.util.*;

public class Solution_최대공약수와최소공배수 {
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        for(int i = Math.min(n,m); i>=1; i--){
            if(n%i==0&&m%i==0){
                answer[0] = i;
                break;
            }
        }
        answer[1] = n*m/answer[0];
        
        return answer;
    }
}
