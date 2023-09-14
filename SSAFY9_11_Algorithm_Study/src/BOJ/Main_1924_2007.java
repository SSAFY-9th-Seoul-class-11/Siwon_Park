package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1924_2007 {
	static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	static int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int dayIdx = 0;
		for(int i = 0; i<x-1; i++) {
			dayIdx += monthDay[i];
		}
		dayIdx += y;
		System.out.println(day[dayIdx%7]);
	}
}
