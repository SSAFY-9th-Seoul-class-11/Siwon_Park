package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279_최대힙_박시원 {

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());

		// 0이 아니면 add, 0이면 출력, 단, 배열이 비어있으면 0을 출력!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while(!priorityQueueHighest.isEmpty()) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				priorityQueueHighest.add(num);
			}else {
				
			}
		}
		
		
	}

}
