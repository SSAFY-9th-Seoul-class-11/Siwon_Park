package Programmers.Lv2;
import java.util.*;
public class Solution_더맵게 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int s : scoville) {
            heap.add(s);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) return -1;
            
            int a = heap.poll();
            int b = heap.poll();
            int result = a + (b * 2);

            heap.add(result);
            answer++;
        }
        return answer;
    }
}
