package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class LeapYear {
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int days = 0;

		ArrayList<Integer> month31 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
		ArrayList<Integer> month30 = new ArrayList<>(Arrays.asList(4, 6, 9, 11));

		if (month31.contains(month)) {
			days = 31;
		} else if (month30.contains(month)) {
			days = 30;
		} else if (month == 2) {
			if ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}
		System.out.println(days + " days for " + year + "-" + month);
	}
}
