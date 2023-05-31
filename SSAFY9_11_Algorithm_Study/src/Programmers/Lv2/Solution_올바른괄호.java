package Programmers.Lv2;

import java.util.Stack;

public class Solution_올바른괄호 {
	boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        for(int i = 0; i<s.length(); i++) {
        	if(arr[i] == '(') {
        		stack.add(arr[i]);
        	}else {
				if(!stack.isEmpty() || stack.peek()=='(') {
					stack.pop();
				}else {
					answer = false;
					break;
				}
			}
        }
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}
