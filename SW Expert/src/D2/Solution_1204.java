package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1204 {

	public static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			int t = sc.nextInt();
			int cnt = 0;
			int cntTemp = 0;
			num = new int[1000];
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < 1000; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);

			for (int i = 0; i < 999; i++) {
				if (num[i] == num[i + 1]) {
					cntTemp++;
				} else {
					if (cntTemp < cnt) {
						cntTemp = 0;
						continue;
					} else {
						max = num[i];
						cnt = cntTemp;
						cntTemp = 0;
					}

				}

			}

			System.out.println("#" + T + " " + max);
		}
	}
}
