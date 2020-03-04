import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1907_BFS {

	static int TestCase;
	static int H, W;
	static int[][] map;

	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };

	static class Node {
		int y;
		int x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
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
					char c = s.charAt(j);
					if (c != '.')
						map[i][j] = c - '0';

				}
			}
			printMap(map);
			Queue<Node> que = new LinkedList<>();

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 0) {
						for (int k = 0; k < 8; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];

							if (!safe(ny, nx))
								continue;

							if (map[ny][nx] > 0) {
								map[ny][nx]--;

								// 원래 모래였는데 깎여서 바다가 됨: -1
								if (map[ny][nx] == 0) {
									map[ny][nx] = -1;
									que.add(new Node(ny, nx));
								}
							}
						}
					}
				}
			}

			printMap(map);
			int wave = 0;

			while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					Node node = que.poll();

					for (int k = 0; k < 8; k++) {
						int ny = node.y + dy[k];
						int nx = node.x + dx[k];

						if (!safe(ny, nx))
							continue;

						if (map[ny][nx] > 0) {
							map[ny][nx]--;

							// 원래 모래였는데 깎여서 바다가 됨: -1
							if (map[ny][nx] == 0) {
								map[ny][nx] = -1;
								que.add(new Node(ny, nx));
							}
						}
					}
				}
				printMap(map);
				wave++;
			}
			System.out.println("#" + T + " " + wave);

		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < W && y >= 0 && y < H) {
			return true;
		} else
			return false;
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
