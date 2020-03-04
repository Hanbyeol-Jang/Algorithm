package D2;

import java.util.Scanner;

public class Solution_1926 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			int num = cntThree(i);

			if (num == 1) {
				System.out.print("- ");
			} else if (num == 2) {
				System.out.print("-- ");
			} else if (num == 3) {
				System.out.print("--- ");
			} else
				System.out.print(i + " ");
		}

	}

	public static int cntThree(int num) {
		int cnt = 0;

		int hund = num / 100;
		num %= 100;
		int ten = num / 10;
		int one = num % 10;

		String s = hund + "";
		if (s.contains("3") || s.contains("6") || s.contains("9")) {
			cnt++;
		}

		s = ten + "";

		if (s.contains("3") || s.contains("6") || s.contains("9")) {
			cnt++;
		}

		s = one + "";

		if (s.contains("3") || s.contains("6") || s.contains("9")) {
			cnt++;
		}

		return cnt;
	}
}
