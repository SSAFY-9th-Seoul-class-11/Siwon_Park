package Programmers.Lv1;
import java.util.*;

public class Solution_두개뽑아서더하기 {
	public int[] solution(int[] numbers) {
		Set<Integer> hset = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				hset.add(numbers[i] + numbers[j]);
			}
		}
		int[] answer = new int[hset.size()];
		int idx = 0;
		for (Integer i : hset) {
			answer[idx] = i;
			idx++;
		}
		Arrays.sort(answer);
		return answer;
	}
}
