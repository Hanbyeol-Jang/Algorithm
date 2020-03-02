package D4;

import java.util.Scanner;

public class Solution_7208 {

	static int TestCase;
	static int N;
	static int[] color;
	static int[][] map;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			color = new int[N + 1];
			map = new int[N + 1][N + 1];
			visited = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				color[i] = sc.nextInt();
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

//			printCol(color);
			min = Integer.MAX_VALUE;

			dfs(1, 0);
//			printCol(color);

			System.out.println("#" + T + " " + min);

		}
	}

	public static void dfs(int v, int cnt) {
		if (v == N) {
			boolean isTrue = true;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1 && color[i] == color[j]) {
						isTrue = false;
						break;
					}
				}
			}

			if (isTrue) {
				min = Math.min(min, cnt);
			}
			return;

		}

		int temp = 0;

		for (int i = 1; i <= 4; i++) {
			if (color[v] == i) {
				dfs(v + 1, cnt);
			} else {
				temp = color[v];
				color[v] = i;
				dfs(v + 1, cnt + 1);
				color[v] = temp;
			}

		}

	}

	public static void printCol(int[] c) {
		for (int i = 1; i <= N; i++) {
			System.out.print(color[i] + " ");
		}
		System.out.println();
	}

}
