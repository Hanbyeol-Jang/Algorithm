package D2;

import java.util.Scanner;

public class Solution_1989 {

	static int TestCase;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			String s = sc.next();
			char[] c = s.toCharArray();

			int len = s.length();
			int cnt = 0;

			for (int i = 0; i < len / 2; i++) {
				if (c[i] == c[len - 1 - i]) {
					cnt++;
				}
			}

			if (cnt == len / 2)
				System.out.println("#" + T + " 1");
			else
				System.out.println("#" + T + " 0");

		}
	}
}
