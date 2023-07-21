package Programmers.Lv1;

public class Solution_크기가작은부분문자열 {
	public int solution(String t, String p) {
        int answer = 0;
        int tsize = t.length();
        int psize = p.length();
        Long pint = Long.parseLong(p);
        for(int i = 0; i<=tsize-psize; i++){
            if(Long.parseLong(t.substring(i, i+psize))<=pint) answer++;
        }
        return answer;
    }
}
