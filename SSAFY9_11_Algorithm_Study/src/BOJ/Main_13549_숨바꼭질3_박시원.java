package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3_박시원 {
	static class Node{
		int x, time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	static int N, K;
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //수빈 위치
		K = Integer.parseInt(st.nextToken()); //동생 위치
		                 
		find();

	}
	
	public static void find() {
		queue.add(new Node(N, 1));
		int[] time = new int[100001];//해당 위치에서의 시간 체크
		time[N] = 1;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if(n.x+1>=0 && n.x+1<=100000) {
				if(time[n.x+1] == 0 || time[n.x+1] > n.time+1) {
					time[n.x+1] = n.time+1;
					queue.add(new Node(n.x+1, n.time+1));
				}
			}
			if(n.x-1>=0 && n.x-1<=100000) {
				if(time[n.x-1] == 0 || time[n.x-1] > n.time+1) {
					time[n.x-1] = n.time+1;
					queue.add(new Node(n.x-1, n.time+1));
				}
			}
			if(n.x*2>=0 && n.x*2<=100000) {
				if(time[n.x*2] == 0 || time[n.x*2] > n.time) {
					time[n.x*2] = n.time;
					queue.add(new Node(n.x*2, n.time));
				}
			}
		}
		System.out.println(time[K]-1);
	}

}
