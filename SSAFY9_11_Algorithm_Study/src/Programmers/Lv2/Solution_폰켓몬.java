package Programmers.Lv2;
import java.util.*;

public class Solution_폰켓몬 {
	public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        Set<Integer> hset = new HashSet<>();
        for(int i = 0; i<N; i++){
            hset.add(nums[i]);
        }
        if(hset.size()<N/2) answer = hset.size();
        else answer = N/2;
        return answer;
    }
}
