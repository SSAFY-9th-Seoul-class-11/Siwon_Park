package Programmers.Lv2;

public class Solution_영어끝말잇기 {
	public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        boolean flag = false;

        for(int i = 1; i<words.length; i++){
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            for(int j = 0; j<i; j++){
                
                if(words[i].equals(words[j])){
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        return answer;
    }
}
