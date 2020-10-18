package D3;

import java.util.Scanner;

public class Solution_2805_2 {

	public static int N;
	public static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}

//			printMap(map);

			int up = N / 2 + 1;
			int center = N / 2;

			int sum = 0;
			for (int i = 0; i < up; i++) {
				sum += map[i][center];

				for (int j = 1; j <= i; j++) {
					sum += map[i][center - j];
					sum += map[i][center + j];
				}

			}

			for (int i = 0; i < up - 1; i++) {
				sum += map[N - 1 - i][center];

				for (int j = 1; j <= i; j++) {
					sum += map[N - 1 - i][center - j];
					sum += map[N - 1 - i][center + j];
				}

			}

			System.out.println("#" + T + " " + sum);
		}
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==============");
	}
}
