package D1;

import java.util.Scanner;

public class Solution_2070 {

	static int TestCase;
	static int[] num;
	static char c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			num = new int[2];

			for (int i = 0; i < 2; i++) {
				num[i] = sc.nextInt();
			}

			if (num[0] > num[1])
				c = '>';
			else if (num[0] < num[1])
				c = '<';
			else
				c = '=';

			System.out.println("#" + T + " " + c);

		}

	}

}
