package Programmers.Lv2;

public class Solution_행렬의곱셈 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
         for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                for(int k = 0; k < arr2.length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
