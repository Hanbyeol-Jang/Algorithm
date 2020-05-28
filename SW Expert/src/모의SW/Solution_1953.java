package 모의SW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1953 {

	static int TestCase;
	static int N, M, R, C, L;
	static int hour;
	static int[][] map;
	static boolean[][] visited;

	static int[][] dy = { {}, { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { -1, 0, 0, 0 } };
	static int[][] dx = { {}, { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
			{ 0, 0, -1, 0 }, { 0, 0, -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			map = new int[N][M];
			hour = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			move(R, C);

			int cnt = cntTrue(visited);
			System.out.println("#" + T + " " + cnt);
		}

	}

	public static void move(int y, int x) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(R, C));
		visited = new boolean[N][M];
		visited[R][C] = true;

		int num = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			hour++;
			if (hour == L)
				return;

			for (int s = 0; s < size; s++) {

				Point now = queue.poll();
				num = map[now.y][now.x];

				for (int i = 0; i < 4; i++) {
					int ny = now.y + dy[num][i];
					int nx = now.x + dx[num][i];

					if (!checked(ny, nx))
						continue;
					if (visited[ny][nx])
						continue;
					if (map[ny][nx] == 0)
						continue;
					if (!isPossible(num, i, ny, nx))
						continue;

					queue.add(new Point(ny, nx));
					visited[ny][nx] = true;
				}

			}

		}

	}

	public static int cntTrue(boolean[][] m) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!m[i][j])
					continue;
				cnt++;
			}
		}
		return cnt;
	}

	public static boolean isPossible(int num, int d, int y, int x) {
		boolean poss = false;

		int value = map[y][x];

		switch (num) {
		case 1: {
			if (dy[1][d] == -1 && dx[1][d] == 0) { // 상
				if (value == 1 || value == 2 || value == 5 || value == 6) {
					poss = true;
				}
			} else if (dy[1][d] == 1 && dx[1][d] == 0) { // 하
				if (value == 1 || value == 2 || value == 4 || value == 7) {
					poss = true;
				}
			} else if (dy[1][d] == 0 && dx[1][d] == -1) { // 좌
				if (value == 1 || value == 3 || value == 4 || value == 5) {
					poss = true;
				}
			} else if (dy[1][d] == 0 && dx[1][d] == 1) { // 우
				if (value == 1 || value == 3 || value == 6 || value == 7) {
					poss = true;
				}
			}

			break;
		}
		case 2: {
			if (dy[2][d] == -1 && dx[2][d] == 0) { // 상
				if (value == 1 || value == 2 || value == 5 || value == 6) {
					poss = true;
				}
			} else if (dy[2][d] == 1 && dx[2][d] == 0) { // 하
				if (value == 1 || value == 2 || value == 4 || value == 7) {
					poss = true;
				}
			}

			break;
		}
		case 3: {
			if (dy[3][d] == 0 && dx[3][d] == -1) { // 좌
				if (value == 1 || value == 3 || value == 4 || value == 5) {
					poss = true;
				}
			} else if (dy[3][d] == 0 && dx[3][d] == 1) { // 우
				if (value == 1 || value == 3 || value == 6 || value == 7) {
					poss = true;
				}
			}

			break;
		}
		case 4: {
			if (dy[4][d] == -1 && dx[4][d] == 0) { // 상
				if (value == 1 || value == 2 || value == 5 || value == 6) {
					poss = true;
				}
			} else if (dy[4][d] == 0 && dx[4][d] == 1) { // 우
				if (value == 1 || value == 3 || value == 6 || value == 7) {
					poss = true;
				}
			}

			break;
		}
		case 5: {
			if (dy[5][d] == 1 && dx[5][d] == 0) { // 하
				if (value == 1 || value == 2 || value == 4 || value == 7) {
					poss = true;
				}
			} else if (dy[5][d] == 0 && dx[5][d] == 1) { // 우
				if (value == 1 || value == 3 || value == 6 || value == 7) {
					poss = true;
				}
			}
			break;
		}
		case 6: {
			if (dy[6][d] == 1 && dx[6][d] == 0) { // 하
				if (value == 1 || value == 2 || value == 4 || value == 7) {
					poss = true;
				}
			} else if (dy[6][d] == 0 && dx[6][d] == -1) { // 좌
				if (value == 1 || value == 3 || value == 4 || value == 5) {
					poss = true;
				}
			}

			break;
		}
		case 7: {
			if (dy[7][d] == -1 && dx[7][d] == 0) { // 상
				if (value == 1 || value == 2 || value == 5 || value == 6) {
					poss = true;
				}
			} else if (dy[7][d] == 0 && dx[7][d] == -1) { // 좌
				if (value == 1 || value == 3 || value == 4 || value == 5) {
					poss = true;
				}
			}

			break;
		}
		}

		return poss;
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < M && y >= 0 && y < N) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}

	public static void printMap(boolean[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}

	static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
