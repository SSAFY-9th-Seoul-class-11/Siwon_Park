package Programmers.Lv2;
import java.util.*;
public class Solution_프로세스 {
	public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Boolean> loc = new LinkedList<>();
        for(int i = 0; i<priorities.length; i++){
            queue.add(priorities[i]);
            if(i==location) loc.add(true);
            else loc.add(false);
        }
        int num = 0;
        boolean bool;
        boolean flag;
        while(!queue.isEmpty()){
            num = queue.poll();
            bool = loc.poll();
            flag = true;
            for(Integer q : queue){
                if(num<q) {
                    queue.add(num);
                    loc.add(bool);
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
                if(bool) return answer;
            }
        }
        return answer;
    }
}
