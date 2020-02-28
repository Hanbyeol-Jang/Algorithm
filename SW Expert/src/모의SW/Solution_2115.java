package 모의SW;

import java.util.Scanner;

public class Solution_2115 {

	static int TestCase;
	static int N, M, C;
	static int[][] map;
	static int[][] mapMax;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();

			map = new int[N][N];
			mapMax = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			makeBucket();

//			printMap(map);
//			printMap(mapMax);

			int max = getMax();
			System.out.println("#" + T + " " + max);
		}
	}

	public static void makeBucket() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeSubset(i, j, 0, 0, 0);
			}
		}
	}

	public static void makeSubset(int i, int j, int cnt, int sum, int powSum) {
		if (sum > C)
			return;

		if (cnt == M) {
			if (mapMax[i][j - M] < powSum) {
				mapMax[i][j - M] = powSum;
			}
			return;
		}

		makeSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);
		makeSubset(i, j + 1, cnt + 1, sum, powSum);
	}

	public static int getMax() {
		int max = 0;
		int temp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				for (int k = j + M; k <= N - M; k++) {
					temp = mapMax[i][j] + mapMax[i][k];
					if (max < temp) {
						max = temp;
					}
				}

				for (int l = i + 1; l < N; l++) {
					for (int k = 0; k <= N - M; k++) {
						temp = mapMax[i][j] + mapMax[l][k];
						if (max < temp) {
							max = temp;
						}
					}
				}

			}
		}
		return max;
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("====================");
	}
}
