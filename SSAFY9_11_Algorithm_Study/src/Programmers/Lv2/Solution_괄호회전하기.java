package Programmers.Lv2;
import java.util.*;
public class Solution_괄호회전하기 {
	static int size;
	public int solution(String s) {
        int answer = 0;
        size = s.length();
        for(int i = 0; i<size; i++){
            s += s.substring(0, 1);
            s = s.substring(1, s.length());
            answer += stackCalc(s);
        }
        return answer;
    }
    public int stackCalc(String str){
        Stack<Character> stack = new Stack<>();
        char[] c = new char[str.length()];
        c = str.toCharArray();
        for(int i = 0; i<size; i++){
            if(c[i]=='['||c[i]=='{'||c[i]=='(') {stack.push(c[i]);}
            else{
                if(stack.isEmpty()) return 0;
                if(stack.peek()=='['&&c[i]==']') stack.pop();
                else if(stack.peek()=='{'&&c[i]=='}') stack.pop();
                else if(stack.peek()=='('&&c[i]==')') stack.pop();
            }
        }
        if(stack.isEmpty()) return 1;
        return 0;
    }
}
