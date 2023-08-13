package Programmers.Lv1;

public class Solution_카드뭉치 {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int idx1 = 0; int idx2 = 0;
        for(int i = 0; i<goal.length; i++){
            if(idx1<cards1.length && goal[i].equals(cards1[idx1])) idx1++;
            else if(idx2<cards2.length && goal[i].equals(cards2[idx2])) idx2++;
            else break;
            if(i==goal.length-1) answer = "Yes";
        }
        return answer;
    }
}
