package D1;

import java.util.Scanner;

public class Solution_2029 {

	static int TestCase;
	static int a;
	static int b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			a = sc.nextInt();
			b = sc.nextInt();

			System.out.println("#" + T + " " + a / b + " " + a % b);
		}

	}

}
