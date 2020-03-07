package D2;

import java.util.Scanner;

public class Solution_1986 {

	static int TestCase;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();

			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 1) {
					sum += i;
				} else {
					sum -= i;
				}

			}

			System.out.println("#" + T + " " + sum);
		}

	}
}
