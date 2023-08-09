package Programmers.Lv1;

public class Solution_2016년 {
	static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] firstDay = new int[12]; // 각 달의 1일인 요일 인덱스
    public String solution(int a, int b) {
        String answer = "";
        firstDay[0] = 5;
        for(int i = 1; i<12; i++){
            firstDay[i] = (firstDay[i-1]+monthDays[i-1])%7;
        }
        answer = day[(firstDay[a-1]+b-1)%7];
        return answer;
    }
}
