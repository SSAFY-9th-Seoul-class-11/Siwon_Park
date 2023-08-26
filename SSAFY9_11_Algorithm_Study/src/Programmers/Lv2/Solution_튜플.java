package Programmers.Lv2;
import java.util.*;
public class Solution_튜플 {
	public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");
        String str[] = s.split("-");        
        Arrays.sort(str,new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        StringTokenizer st;
        for(String string : str){
            st = new StringTokenizer(string, ",");
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(!answer.contains(num)) answer.add(num);
            }
        }
        return answer;
    }
}
