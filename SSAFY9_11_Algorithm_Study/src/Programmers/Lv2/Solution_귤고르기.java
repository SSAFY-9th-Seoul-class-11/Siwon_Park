package Programmers.Lv2;
import java.util.*;

public class Solution_귤고르기 {
	public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int[] cnt = new int[tangerine[tangerine.length-1]+1]; // 가장 큰 귤의 크기를 저장할 수 있게 배열 크기로
        for(int i = 0; i<tangerine.length; i++){
            cnt[tangerine[i]]++;
        }
        Arrays.sort(cnt);
        int num = 0;
        for(int i = cnt.length-1; i>0; i--){
            num += cnt[i];
            answer++;
            if(num>=k) break;
        }
        return answer;
    }
}
