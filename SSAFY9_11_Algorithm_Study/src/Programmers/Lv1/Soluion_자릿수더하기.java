package Programmers.Lv1;

public class Soluion_자릿수더하기 {
	public int solution(int n) {
        int answer = 0;

        String num = String.valueOf(n);
        int size = num.length();
        for(int i = 0; i<size;i++) {
        	answer += Integer.parseInt(num.substring(i, i+1));
        }

        return answer;
    }
}
