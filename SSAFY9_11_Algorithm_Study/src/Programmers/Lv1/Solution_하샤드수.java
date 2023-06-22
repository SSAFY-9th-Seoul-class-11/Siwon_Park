package Programmers.Lv1;

public class Solution_하샤드수 {
	public boolean solution(int x) {
        boolean answer = true;
        int size = Integer.toString(x).length();
        int sum = 0;
        int x1 = x;
        for(int i = 0; i<size; i++){
            sum+=x1%10;
            x1/=10;
        }
        if(x%sum!=0) answer = false;
        return answer;
    }
}
