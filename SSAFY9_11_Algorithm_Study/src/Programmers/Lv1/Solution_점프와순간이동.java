package Programmers.Lv1;

public class Solution_점프와순간이동 {
	public int solution(int n) {
        int ans = 0;
        while(n>0){
            if(n%2==0){
                n/=2;
            }else{
                n-=1;
                ans++;
            }
        }
        return ans;
    }
}
