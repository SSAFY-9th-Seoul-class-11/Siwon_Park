package Programmers.Lv2;

import java.util.Stack;

public class Solution_짝지어제거하기 {
	public int solution(String s)
    {
        int answer = 1;
        
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for(int i = 1; i<s.length(); i++) {
        	if(!stack.isEmpty() && stack.peek()==s.charAt(i)) {
        		stack.pop();
        	}else {
        		stack.add(s.charAt(i));
			}
        }
        if(!stack.isEmpty()) answer = 0;

        return answer;
    }
}
