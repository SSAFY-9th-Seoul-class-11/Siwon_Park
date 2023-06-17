package Programmers.Lv1;

public class Solution_문자열내p와y의개수 {

	boolean solution(String s) {
        boolean answer = true;

        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        int p = 0; 
        int y = 0;
        for(int i = 0; i<s.length(); i++){
            if(arr[i]=='p'||arr[i]=='P') p++;
            if(arr[i]=='y'||arr[i]=='Y') y++;
        }
        if(p!=y) answer = false;
        return answer;
    }

}
