package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1984 {
	
	static int TestCase;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			num = new int[10];
			double sum = 0;
			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
				sum += num[i];
			}
			Arrays.sort(num);
			sum -= num[0];
			sum -= num[9];

			System.out.println("#" + T + " " + Math.round(sum / 8));

		}

	}
}
