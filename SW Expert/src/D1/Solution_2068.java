package D1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2068 {

	static int TestCase;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			num = new int[10];

			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
			}

			Arrays.sort(num);

			System.out.println("#" + T + " " + num[9]);

		}

	}

}
