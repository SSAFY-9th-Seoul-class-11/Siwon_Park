package Programmers.Lv1;

public class Solution_최소직사각형 {
	public int solution(int[][] sizes) {
        int answer = 0;
        int maxmax = 0; //큰 길이 쪽 최대값
        int minmax = 0; //작은 길이 쪽 최대값
        for(int i = 0 ; i<sizes.length; i++){
            maxmax = Math.max(maxmax, Math.max(sizes[i][0], sizes[i][1]));
            minmax = Math.max(minmax, Math.min(sizes[i][0], sizes[i][1]));
        }
        answer = maxmax*minmax;
        return answer;
    }
}
