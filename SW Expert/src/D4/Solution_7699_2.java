package D4;

import java.util.Scanner;

public class Solution_7699_2 {

	public static int TestCase;
	public static int R, C;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];

			for (int i = 0; i < R; i++) {
				map[i] = sc.next().toCharArray();
			}
			printMap(map);

		}
	}

	public static void dfs(int y, int x) {
		if (y == R - 1 && x == C - 1) {
			return;
		}

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!checked(ny, nx)) {
				continue;
			}

		}
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < C && y >= 0 && y < R) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(char[][] m) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
