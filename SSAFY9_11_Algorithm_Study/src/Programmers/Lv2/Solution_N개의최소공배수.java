package Programmers.Lv2;
import java.util.*;

public class Solution_N개의최소공배수 {
	public int solution(int[] arr) {
        int size = arr.length;
        if(size == 1) return arr[0];
        Arrays.sort(arr);
        int gcd = arr[0]; // 임시 최대공약수
        int lcm = arr[0]; // 임시 최소공배수
        if(size == 2) return gcd;
        for(int i = 1; i<arr.length; i++){
            gcd = makeGCD(lcm, arr[i]);
            lcm = lcm*arr[i]/gcd;
        }
        return lcm;
    }
    public static int makeGCD(int a, int b){
        for(int i = Math.min(a, b); i>=1; i--){
            if(a%i==0 && b%i==0) return i;
        }
        return 1;
    }
}
