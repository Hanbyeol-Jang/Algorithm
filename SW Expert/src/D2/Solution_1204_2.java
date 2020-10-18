package D2;

import java.util.Scanner;

public class Solution_1204_2 {

	public static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			int t = sc.nextInt();

			num = new int[101];

			for (int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				num[score]++;
			}

			int cnt = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= 100; i++) {
				if (num[i] >= cnt) {
					cnt = num[i];
					max = i;
				}
			}

			System.out.println("#" + T + " " + max);
		}
	}
}
