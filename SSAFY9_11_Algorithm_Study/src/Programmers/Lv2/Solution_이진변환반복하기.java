package Programmers.Lv2;

public class Solution_이진변환반복하기 {
	public int[] solution(String s) {
        int[] answer = new int[2];
        int size;
        while(s.length()>1) {
        	size = 0;
        	for(int i = 0; i<s.length(); i++) {
        		if(s.charAt(i)=='0') {
        			answer[1]++;
        		}else {
        			size++;
        		}
        	}
        	s = Integer.toBinaryString(size); // 1의 개수를 이진수로 바꿔준다
        	answer[0]++;
        }
        return answer;
    }
}
