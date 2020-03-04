package D2;

import java.util.Scanner;

public class Solution_2007 {

	static int TestCase;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			char[] c = sc.next().toCharArray();

			String s = c[0] + "";
			String first = c[0] + "";

			for (int i = 1; i < c.length; i++) {
				if (!first.equals(c[i] + "")) {
					s += c[i];
				} else {
					int len = s.length();
					int cnt = 0;
					for (int j = 0; j < len; j++) {
						if (s.charAt(j) == c[i + j]) {
							cnt++;
						}
					}
					if (cnt == len) {
						System.out.println("#" + T + " " + i);
						break;
					} else {
						s += c[i];
					}

				}
			}

		}
	}
}
