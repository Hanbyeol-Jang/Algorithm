package D5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1907 {

	static int TestCase;
	static int H, W;
	static int[][] map;
	static int cnt;
	static int[][] cntMap;

	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static Queue<Node> queue = new LinkedList<>();

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

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
					char ch = s.charAt(j);

					if (ch != '.') {
						map[i][j] = ch - '0';
					} else {
						map[i][j] = 0;
					}
				}
			}

			cntMap = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 0)
						continue;

					cnt = 0;
					cntSand(i, j);
					cntMap[i][j] = cnt;
				}
			}

			destroy();

			int wave = 0;
			while (!queue.isEmpty()) {
				wave++;

				int size = queue.size();
				for (int s = 0; s < size; s++) {
					Node node = queue.poll();
					for (int i = 0; i < 8; i++) {
						int ny = node.r + dy[i];
						int nx = node.c + dx[i];

						if (!checked(ny, nx))
							continue;

						if (map[ny][nx] != 0) {
							cntMap[ny][nx]--;
						}
					}
				}

				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						if (map[i][j] == 0)
							continue;

						cnt = 0;
						cntSand(i, j);
						cntMap[i][j] = cnt;
					}
				}
				destroy();

			}

			System.out.println("#" + T + " " + wave);
		}
	}

	public static void destroy() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 0)
					continue;

				if (map[i][j] <= cntMap[i][j]) {
					map[i][j] = 0;
					queue.offer(new Node(i, j));
				}
			}
		}
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < W && y >= 0 && y < H) {
			return true;
		} else
			return false;
	}

	public static void cntSand(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!checked(ny, nx))
				continue;

			if (map[ny][nx] == 0)
				cnt++;
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=================");
	}

}
