package D5;

import java.util.Scanner;

public class Solution_1907 {

	static int TestCase;
	static int H, W;
	static int[][] map;
	static int[][] checked;

	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				String s = sc.next();
				for (int j = 0; j < W; j++) {
					char c = s.charAt(j);
					if (c != '.') {
						map[i][j] = c - '0';
					}
				}
			}

			int wave = 0;

			while (true) {
				boolean destroy = false;
				checked = new int[H][W];

				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						if (map[i][j] == 0)
							continue;

						checkSand(i, j);
					}
				}

				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						if (checked[i][j] == 0)
							continue;

						if (checked[i][j] >= map[i][j]) {
							map[i][j] = 0;

							destroy = true;
						}

					}
				}

				wave++;

				if (!destroy) {
					wave--;
					System.out.println("#" + T + " " + wave);
					break;
				}
			}

		}

	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < W && y >= 0 && y < H) {
			return true;
		} else
			return false;
	}

	public static void checkSand(int y, int x) {

		int cntSand = 0;

		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!safe(ny, nx))
				continue;

			if (map[ny][nx] == 0) {
				cntSand++;
			}
		}

		checked[y][x] = cntSand;
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============================");
	}
}
