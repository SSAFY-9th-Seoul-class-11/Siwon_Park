package Programmers.Lv1;

public class Solution_가장가까운같은글자 {
	public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        boolean flag;
        char[] c = new char[s.length()];
        c = s.toCharArray();
        for(int i = 1; i<s.length(); i++){
            flag = false;
            for(int j = i-1; j>=0; j--){
                if(c[i]==c[j]) {
                    answer[i] = i-j;
                    flag = true;
                    break;
                }
            }
            if(!flag) answer[i] = -1;
        }
        return answer;
    }
}
