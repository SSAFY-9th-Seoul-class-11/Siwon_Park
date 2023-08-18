package Programmers.Lv2;
import java.util.*;
public class Solution_할인행사 {
	public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean flag;
        for(int i = 0; i<=discount.length-10; i++){
            flag = true;
            for(int j = 0; j<want.length; j++){
                if(Collections.frequency(tenDays(discount, i), want[j])<number[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
    
    public ArrayList<String> tenDays(String[] discount, int idx){
        ArrayList<String> arrlist = new ArrayList<>();
        for(int i = 0; i<10; i++){
            arrlist.add(discount[i+idx]);
        }
        return arrlist;
    }
}
