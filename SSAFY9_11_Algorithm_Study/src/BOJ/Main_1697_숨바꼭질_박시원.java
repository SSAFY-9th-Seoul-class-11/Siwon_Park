package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질_박시원 {
	static int N, K; 
	static int min;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		min = Math.abs(K-N); //최대시간을 최소로 초기화
		
		if(K<=N) min = N-K;
		else find();
		System.out.println(min);
	}
	
	public static void find() {
		queue.add(N);
		int[] time = new int[100001];//해당 위치에서의 시간 체크
		time[N] = 1;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for(int i = 0; i<3; i++) {
				int nx = 0;
				if(i == 0) nx = x-1;
				else if(i == 1) nx = x+1;
				else if(i == 2) nx = x*2;
				
				if(nx == K) {
					if(min>time[x]) min = time[x];
					return;
				}
				
				if(nx<=100000 && nx>=0 && time[nx] == 0) {
					time[nx] = time[x]+1;
					queue.add(nx);
				}	
			}	
		}
		return;
	}
}