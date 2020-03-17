package D2;

import java.util.Scanner;

public class Solution_1946 {

	static int TestCase;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				int num = sc.nextInt();

				for (int j = 0; j < num; j++) {
					sb.append(s);
				}
			}

			System.out.println("#" + T);
			for (int i = 0; i < sb.length(); i++) {
				if (i != 0 && (i % 10 == 0)) {
					System.out.println();
				}
				System.out.print(sb.charAt(i));
			}
			System.out.println();
		}
	}
}
