package D2;

import java.util.Scanner;

public class Solution_1970 {

	static int TestCase;
	static int N;
	static int[] change;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			change = new int[8];

			change[0] = N / 50000;
			N %= 50000;
			change[1] = N / 10000;
			N %= 10000;
			change[2] = N / 5000;
			N %= 5000;
			change[3] = N / 1000;
			N %= 1000;
			change[4] = N / 500;
			N %= 500;
			change[5] = N / 100;
			N %= 100;
			change[6] = N / 50;
			N %= 50;
			change[7] = N / 10;
			N %= 10;
			
			System.out.println("#" + T);
			for (int i = 0; i < 8; i++) {
				System.out.print(change[i] + " ");
			}
			System.out.println();
		}
	}
}
