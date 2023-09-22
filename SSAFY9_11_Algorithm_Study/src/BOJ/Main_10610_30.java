package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10610_30 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = br.readLine();
		int[] nums = new int[num.length()];
		int sum = 0;
		for(int i = 0; i<num.length(); i++) {
			nums[i] = Integer.parseInt(num.substring(i, i+1));
			sum += nums[i];
		}
		Arrays.sort(nums);
		if(nums[0]!=0 || sum%3!=0 || num.length()==1) System.out.println(-1);
		else{
			for(int i = num.length()-1; i>=0; i--) {
				sb.append(nums[i]);
			}
			System.out.println(sb);
		}
	}
}
