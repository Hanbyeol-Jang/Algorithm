package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_8382 {

	static int TestCase;
	static int Sx, Sy, Ex, Ey;
	static boolean[][][] visited;
	static Queue<Point> que;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static class Point {
		int y;
		int x;
		int cnt;
		boolean dir;

		Point(int y, int x, int cnt, boolean dir) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			Sx = sc.nextInt() + 100;
			Sy = sc.nextInt() + 100;
			Ex = sc.nextInt() + 100;
			Ey = sc.nextInt() + 100;

			que = new LinkedList<>();
			visited = new boolean[201][201][2];

			que.add(new Point(Sy, Sx, 0, true));
			que.add(new Point(Sy, Sx, 0, false));

			visited[Sy][Sx][0] = true;
			visited[Sy][Sx][1] = true;

			while (!que.isEmpty()) {
				Point point = que.poll();

				if (point.x == Ex && point.y == Ey) {
					System.out.println("#" + T + " " + point.cnt);
					break;
				}

				if (!point.dir) {
					for (int i = 0; i < 2; i++) {
						int ny = point.y + dy[i];
						int nx = point.x + dx[i];

						if (!safe(ny, nx))
							continue;

						if (visited[ny][nx][0])
							continue;

						que.add(new Point(ny, nx, point.cnt + 1, !point.dir));
						visited[ny][nx][0] = true;
					}

				} else {
					for (int i = 2; i < 4; i++) {
						int ny = point.y + dy[i];
						int nx = point.x + dx[i];

						if (!safe(ny, nx))
							continue;

						if (visited[ny][nx][1])
							continue;

						que.add(new Point(ny, nx, point.cnt + 1, !point.dir));
						visited[ny][nx][1] = true;
					}
				}

			}

		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x <= 200 && y >= 0 && y <= 200) {
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
