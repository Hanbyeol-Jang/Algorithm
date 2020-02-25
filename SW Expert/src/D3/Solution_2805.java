package D3;

import java.util.Scanner;

public class Solution_2805 {

	static int TestCase;
	static int N;

	static int[][] map;
	static String s;

	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			map = new int[N][N];
			sum = 0;

			for (int i = 0; i < N; i++) {
				s = sc.next();
				char[] c = s.toCharArray();

				for (int j = 0; j < N; j++) {
					map[i][j] = c[j] - '0';
				}
			}

			for (int i = 0; i <= N / 2; i++) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					// System.out.println(map[i][j] + " " + i + " " + j);
					sum += map[i][j];
				}
			}
			for (int i = N - 1; i > N / 2; i--) {
				for (int j = N / 2 - (N - 1 - i); j <= N / 2 + (N - 1 - i); j++) {
					// System.out.println(map[i][j] + " " + i + " " + j);
					sum += map[i][j];
				}
			}

			System.out.println("#" + T + " " + sum);

		}
	}

}