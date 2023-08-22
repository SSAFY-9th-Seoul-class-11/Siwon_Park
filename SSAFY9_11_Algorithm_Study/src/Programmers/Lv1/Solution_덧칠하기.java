package Programmers.Lv1;

public class Solution_덧칠하기 {
	public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = 0;
        boolean[] isColored = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            if(idx>=section.length) break;
            if(i==section[idx]){
                if(!isColored[i]) {
                    for(int j = i; j<i+m; j++){
                        if(j>n) break;
                        isColored[j] = true;
                    }
                    answer++;
                }
                idx++;
            }
        }
        return answer;
    }
}
