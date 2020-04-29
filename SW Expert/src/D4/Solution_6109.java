package D4;

import java.util.Scanner;

public class Solution_6109 {

	static int TestCase;
	static int N;
	static String s;
	static int[][] map;
	static int ny, nx, py, px;

	static int[] Sy = { -1, 0, 1, 0 };
	static int[] Sx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			s = sc.next();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			if (N != 2) {
				switch (s) {
				case "up":
					ny = Sy[0];
					nx = Sx[0];
					py = Sy[2];
					px = Sx[2];

					pushUp();

					for (int j = 0; j < N; j++) {
						for (int i = 1; i < N; i++) {
							if (i + 1 == N) {
								continue;
							}

							if (map[i][j] == 0) {
								pushUp();
							}

							multi(i, j);

						}
					}
					pushUp();
					break;
				case "down":
					ny = Sy[2];
					nx = Sx[2];
					py = Sy[0];
					px = Sx[0];

					pushDown();

					for (int j = N - 1; j >= 0; j--) {
						for (int i = N - 2; i >= 0; i--) {
							if (i - 1 == -1) {
								continue;
							}

							if (map[i][j] == 0) {
								pushDown();
							}

							multi(i, j);

						}
					}
					pushDown();
					break;
				case "right":
					ny = Sy[1];
					nx = Sx[1];
					py = Sy[3];
					px = Sx[3];

					pushRight();

					for (int j = N - 2; j >= 0; j--) {
						for (int i = N - 1; i >= 0; i--) {
							if (j - 1 == -1) {
								continue;
							}

							if (map[i][j] == 0) {
								pushRight();
							}

							multi(i, j);

						}
					}
					pushRight();
					break;
				case "left":
					ny = Sy[3];
					nx = Sx[3];
					py = Sy[1];
					px = Sx[1];

					pushLeft();

					for (int j = 1; j < N; j++) {
						for (int i = 0; i < N; i++) {
							if (j + 1 == N) {
								continue;
							}

							if (map[i][j] == 0) {
								pushLeft();
							}
							multi(i, j);
						}
					}
					pushLeft();
					break;
				}
			} else {
				switch (s) {
				case "up":

					for (int i = 0; i < 2; i++) {
						if (map[0][i] == 0) {
							map[0][i] = map[1][i];
							map[1][i] = 0;
						}

						if (map[0][i] == map[1][i]) {
							map[0][i] *= 2;
							map[1][i] = 0;
						}
					}

					break;
				case "down":

					for (int i = 1; i >= 0; i--) {
						if (map[1][i] == 0) {
							map[1][i] = map[0][i];
							map[0][i] = 0;
						}

						if (map[1][i] == map[0][i]) {
							map[1][i] *= 2;
							map[0][i] = 0;
						}
					}
					break;
				case "right":
					for (int i = 1; i >= 0; i--) {
						if (map[i][1] == 0) {
							map[i][1] = map[i][0];
							map[i][0] = 0;
						}

						if (map[i][1] == map[i][0]) {
							map[i][1] *= 2;
							map[i][0] = 0;
						}
					}

					break;
				case "left":
					for (int i = 0; i < 2; i++) {
						if (map[i][0] == 0) {
							map[i][0] = map[i][1];
							map[i][1] = 0;
						}

						if (map[i][0] == map[i][1]) {
							map[i][0] *= 2;
							map[i][1] = 0;
						}
					}

					break;

				}
			}
			System.out.println("#" + T);
			printMap(map);
		}
	}

	public static void multi(int i, int j) {
		if (map[i + ny][j + nx] == map[i][j]) {
			map[i + ny][j + nx] *= 2;
			map[i][j] = map[i + py][j + px];
			map[i + py][j + px] = 0;
		}
	}

	public static void push(int i, int j) {
		if (map[i][j] == 0) {
			map[i][j] = map[i + py][j + px];
			map[i + py][j + px] = 0;
		}
	}

	public static void pushUp() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (i + 1 == N) {
					continue;
				}

				push(i, j);
			}
		}
	}

	public static void pushDown() {
		for (int j = N - 1; j >= 0; j--) {
			for (int i = N - 1; i >= 0; i--) {
				if (i - 1 == -1) {
					continue;
				}

				push(i, j);
			}
		}
	}

	public static void pushLeft() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (j + 1 == N) {
					continue;
				}

				push(i, j);
			}
		}
	}

	public static void pushRight() {
		for (int j = N - 1; j >= 0; j--) {
			for (int i = N - 1; i >= 0; i--) {
				if (j - 1 == -1) {
					continue;
				}

				push(i, j);
			}
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
