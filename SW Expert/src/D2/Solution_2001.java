package D2;

import java.util.Scanner;

public class Solution_2001 {

	static int TestCase;
	static int N, M;
	static int[][] map;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int k = 0; k <= N - M; k++) {
				for (int l = 0; l <= N - M; l++) {
					int sum = 0;
					for (int i = k; i < M + k; i++) {
						for (int j = l; j < M + l; j++) {
							sum += map[i][j];
						}
					}
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + T + " " + max);

		}
	}
}
