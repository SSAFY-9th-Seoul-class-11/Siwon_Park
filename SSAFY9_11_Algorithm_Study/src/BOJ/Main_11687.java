package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11687 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int M = Integer.parseInt(br.readLine());
 
        int left=1;
        int right=M*5;
 
        boolean check=false;
        while(left<=right){
            int mid = (left+right)/2;
            if(solve(mid)>M){
                right=mid-1;
            } else if(solve(mid)==M){
                right=mid-1;
                check=true;
            }
            else{
                left = mid+1;
            }
        }
 
        if(check){
            System.out.println(left);
        }else{
            System.out.println(-1);
        }
    }
 
    private static int solve(int mid){
        int count=0;
 
        for(int i=5; i<=mid; i*=5){
            count+=(mid/i);
        }
 
        return count;
    }
}
