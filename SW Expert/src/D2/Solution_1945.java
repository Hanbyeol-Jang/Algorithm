package D2;

import java.util.Scanner;

public class Solution_1945 {

	static int TestCase;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;

			while (true) {
				if (N % 11 != 0)
					break;
				N /= 11;
				e++;
			}
			while (true) {
				if (N % 7 != 0)
					break;
				N /= 7;
				d++;
			}
			while (true) {
				if (N % 5 != 0)
					break;
				N /= 5;
				c++;
			}
			while (true) {
				if (N % 3 != 0)
					break;
				N /= 3;
				b++;
			}
			while (true) {
				if (N % 2 != 0)
					break;
				N /= 2;
				a++;
			}

			System.out.println("#" + T + " " + a + " " + b + " " + c + " " + d + " " + e);

		}
	}
}
