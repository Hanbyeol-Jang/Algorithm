package D1;

import java.util.Scanner;

public class Solution_2056 {

	static int TestCase;
	static String s;

	static String result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			s = sc.next();
			char[] date = s.toCharArray();

			int month = Integer.parseInt("" + date[4] + date[5]);
			int day = Integer.parseInt("" + date[6] + date[7]);

			if (month <= 0 || month > 12)
				result = "-1";
			else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if (day <= 0 || day > 31) {
					result = "-1";
				} else {
					result = makeDate(date);
				}

			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day <= 0 || day > 30) {
					result = "-1";
				} else {
					result = makeDate(date);
				}

			} else {
				if (day <= 0 || day > 28) {
					result = "-1";
				} else {
					result = makeDate(date);
				}

			}

			System.out.println("#" + T + " " + result);

		}

	}
	
	public static String makeDate(char[] date) {
		String result = "" + date[0] + date[1] + date[2] + date[3] + "/" + date[4] + date[5] + "/" + date[6]
				+ date[7];
		return result;
	}
}
