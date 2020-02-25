package D1;

import java.util.Scanner;

public class Solution_2071 {

	static int TestCase;
	static int[] num;
	static int sum;
	static double avg;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {

			num = new int[10];
			sum = 0;
			avg = 0;

			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();

				sum += num[i];
			}

			avg = Math.round(sum / 10.0);

			System.out.printf("#%d %.0f\n",T, avg);

		}
	}
}
