package Programmers.Lv1;

public class Solution_시저암호 {
	public String solution(String s, int n) {
        String answer = "";
        char[] c = new char[s.length()];
        c = s.toCharArray();
        for(int i = 0; i<s.length(); i++){
            if(c[i]!=' '){
                if(c[i]+n>'z'||(c[i]<='Z'&&c[i]+n>'Z')){
                    c[i]-=26;
                }
                c[i]+=n;
            }
            answer += c[i];
        }
        return answer;
    }
}
