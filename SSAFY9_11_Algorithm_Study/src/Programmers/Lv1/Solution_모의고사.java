package Programmers.Lv1;
import java.util.*;
public class Solution_모의고사 {
	public ArrayList solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] supo = {{1, 2, 3, 4, 5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int maxCnt = 0;
        int[] cnt = new int[3];
        int idx;
        for(int i = 0; i<3; i++){
            idx = 0;
            for(int j = 0; j<answers.length; j++){
                if(answers[j]==supo[i][idx]) cnt[i]++;
                if(idx==supo[i].length-1) idx = 0;
                else idx++;
            }
            if(maxCnt==cnt[i]) {
                answer.add(i+1);
            }if(maxCnt<cnt[i]){
                maxCnt = cnt[i];
                answer.clear();
                answer.add(i+1);
            }
        }
        return answer;
    }
}
