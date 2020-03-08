package D2;

import java.util.Scanner;

public class Solution_1976 {

	static int TestCase;
	static int h, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();

			h = h1 + h2;
			m = m1 + m2;

			if (m >= 60) {
				m -= 60;
				h += 1;
			}
			if (h > 12) {
				h -= 12;
			}
			System.out.println("#" + T + " " + h + " " + m);
		}
	}
}
