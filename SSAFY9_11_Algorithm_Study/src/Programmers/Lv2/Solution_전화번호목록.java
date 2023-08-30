package Programmers.Lv2;
import java.util.*;
public class Solution_전화번호목록 {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                return answer;
            }   
        }      
        return answer;
    }
}
