package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845_큐 {

	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static int last = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			order(br.readLine());
		}
		System.out.println(sb);
	}
	
	public static void order(String str) {
		StringTokenizer st = new StringTokenizer(str);
		switch (st.nextToken()) {
		case "push":
			last = Integer.parseInt(st.nextToken());
			q.add(last);
			break;
		case "pop":
			if(q.isEmpty())sb.append(-1 + "\n");
			else sb.append(q.poll() + "\n");
			break;
		case "size":
			sb.append(q.size() + "\n");
			break;
		case "empty":
			if(q.isEmpty()) sb.append(1 + "\n");
			else sb.append(0).append("\n");
			break;
	case "front":
		if(q.isEmpty()) sb.append(-1 + "\n");
		else sb.append(q.peek() + "\n");
		break;
	case "back":
		if(q.isEmpty()) sb.append(-1 + "\n");
		else sb.append(last + "\n");
		break;
		}
	}

}
