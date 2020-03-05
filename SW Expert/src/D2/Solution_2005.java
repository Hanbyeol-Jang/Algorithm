package D2;

import java.util.Scanner;

public class Solution_2005 {

	static int TestCase;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= i / 2; j++) {
					System.out.print(j + " ");
				}
				for (int j = i / 2+1; j < i; j++) {
					System.out.print(j + " ");
				}
				System.out.println();
			}

		}
	}
}
