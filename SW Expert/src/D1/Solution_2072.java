package D1;

import java.util.Scanner;

public class Solution_2072 {

	static int TestCase;
	static int[] num;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			num = new int[10];
			sum = 0;

			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
				if (num[i] % 2 == 1) {
					sum += num[i];
				}
			}

			System.out.println("#" + T + " " + sum);

		}
	}
}
