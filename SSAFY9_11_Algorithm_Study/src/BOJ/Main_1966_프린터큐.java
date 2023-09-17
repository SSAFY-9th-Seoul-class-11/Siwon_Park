package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; int N, M, cnt;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			LinkedList<Integer> queue = new LinkedList<>();
			LinkedList<Integer> idx = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
				idx.add(i);
			}
			cnt = 0;
			while(true) {
				if(compare(queue, queue.peek())) {
					cnt++;
					if(idx.poll()==M) {
						System.out.println(cnt);
						break;
					}
					queue.poll();
				}else {
					queue.add(queue.poll());
					idx.add(idx.poll());
				}
			}
		}
		
	}
	public static boolean compare(LinkedList<Integer> q, int first) {
		for(int i = 1; i<q.size(); i++) {
			if(q.get(i)>first) return false;
		}
		return true;
	}
	
}
