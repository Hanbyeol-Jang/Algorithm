package D2;

import java.util.Scanner;

public class Solution_1948 {

	static int TestCase;
	static int m1, d1, m2, d2;
	static int[] month;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();
		initMonth();
		
		for (int T = 1; T <= TestCase; T++) {
			m1 = sc.nextInt();
			d1 = sc.nextInt();
			m2 = sc.nextInt();
			d2 = sc.nextInt();
			cnt = 0;

			if (m1 == m2) {
				cnt = d2 - d1 + 1;
			} else if (m2 - m1 == 1) {
				cnt = month[m1] - d1 - 1 + d2;
			} else if (m2 - m1 >= 2) {
				cnt = month[m1] - d1 + 1 + d2;
				for (int i = m1 + 1; i <= m2 - 1; i++) {
					cnt += month[i];
				}
				
			}

			System.out.println("#" + T + " " + cnt);
		}
	}

	public static void initMonth() {
		month = new int[13];
		month[1] = 31;
		month[2] = 28;
		month[3] = 31;
		month[4] = 30;
		month[5] = 31;
		month[6] = 30;
		month[7] = 31;
		month[8] = 31;
		month[9] = 30;
		month[10] = 31;
		month[11] = 30;
		month[12] = 31;
	}
}
