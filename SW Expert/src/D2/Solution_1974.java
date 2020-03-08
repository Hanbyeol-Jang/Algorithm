package D2;

import java.util.Scanner;

public class Solution_1974 {

	static int TestCase;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			if (!horizon() || !vertical() || !square()) {
				System.out.println("#" + T + " 0");
			} else
				System.out.println("#" + T + " 1");

		}
	}

	public static boolean horizon() {
		for (int i = 0; i < 9; i++) {
			check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				check[map[i][j]] = true;
			}
			if (!check(check))
				return false;
		}
		return true;
	}

	public static boolean vertical() {
		for (int j = 0; j < 9; j++) {
			check = new boolean[10];
			for (int i = 0; i < 9; i++) {
				check[map[i][j]] = true;
			}
			if (!check(check))
				return false;
		}
		return true;
	}

	public static boolean square() {

		for (int k = 0; k < 9; k += 3) {
			for (int l = 0; l < 9; l += 3) {
				check = new boolean[10];
				for (int i = k; i < k + 3; i++) {
					for (int j = l; j < l + 3; j++) {
						check[map[i][j]] = true;
					}

				}
				if (!check(check))
					return false;

			}
		}

		return true;
	}

	public static boolean check(boolean[] c) {
		for (int i = 1; i <= 9; i++) {
			if (c[i] == false) {
				return false;
			}
		}
		return true;
	}
}
