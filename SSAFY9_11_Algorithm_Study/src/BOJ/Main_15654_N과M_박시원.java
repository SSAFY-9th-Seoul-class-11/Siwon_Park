package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M_박시원 {
	static int N, M;
	private static boolean[] isSelected;
	static int[] nums, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		result = new int[M];
		isSelected = new boolean[N+1];
		permutation(0);

	}
	
	private static void permutation(int cnt) { 
		if(cnt == M)  {
			for(int i = 0; i<M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {  
			if(isSelected[i]) continue;
			result[cnt] = nums[i];
			isSelected[i] = true; 
			permutation(cnt + 1);
			isSelected[i] = false; 
		}
	}


}
