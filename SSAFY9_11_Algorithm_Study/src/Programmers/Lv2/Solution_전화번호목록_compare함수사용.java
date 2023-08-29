package Programmers.Lv2;
import java.util.*;
class Solution {
	public class Solution_전화번호목록 {
		public boolean solution(String[] phone_book) {
			boolean answer = true;
			Arrays.sort(phone_book, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s1.length() - s2.length();
				}
			});
			for (int i = 0; i < phone_book.length; i++) {
				for (int j = i + 1; j < phone_book.length; j++) {
					if (phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
						answer = false;
						return answer;
					}
				}
			}
			return answer;
		}
	}
}
