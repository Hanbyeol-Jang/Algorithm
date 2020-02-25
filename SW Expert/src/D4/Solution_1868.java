package D4;

import java.util.Scanner;

public class Solution_1868 {

	static int TestCase;
	static int N;
	static char[][] map;
	static int cntBomb;
	static int click;

	static int[][] pop;
	static boolean[][] visited;

	static int[] dy = { 0, 1, -1, 1, -1, 1, 0, -1 };
	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			map = new char[N][N];
			pop = new int[N][N];
			visited = new boolean[N][N];
			click = 0;

			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}

			for (int i = 0; i < N; i++) { // 0 일때 미리 다 체크
				for (int j = 0; j < N; j++) {
					if (map[i][j] != '*' && !visited[i][j]) {
						if (isZero(i, j)) {
							visited[i][j] = true;
							click++;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != '*' && !visited[i][j]) {
						dfs(i, j);
						click++;
					}
				}
			}

			System.out.println("#" + T + " " + click);

		}
	}

	public static int checkBomb(int y, int x) {
		int ckBomb = 0;

		for (int i = 0; i < 8; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] == '*' && !visited[y + dy[i]][x + dx[i]]) {
				ckBomb++;
			}
		}
		return ckBomb;
	}

	public static boolean isZero(int y, int x) {
		cntBomb = checkBomb(y, x);

		if (cntBomb > 0) {
			nearZero(y, x);
			return false;
		}

		for (int i = 0; i < 8; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] != '*' && !visited[y + dy[i]][x + dx[i]]) {
				visited[y + dy[i]][x + dx[i]] = true;
				isZero(y + dy[i], x + dx[i]);
			}
		}

		return true;
	}

	public static void nearZero(int y, int x) {
		cntBomb = checkBomb(y, x);
		pop[y][x] = cntBomb;
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;
		cntBomb = checkBomb(y, x);

		if (cntBomb != 0) {
			pop[y][x] = cntBomb;
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] != '*' && !visited[y + dy[i]][x + dx[i]]) {
				visited[y + dy[i]][x + dx[i]] = true;
				dfs(y + dy[i], x + dx[i]);
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		} else
			return false;
	}

	public static void printMap(char[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("======================");
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("======================");
	}

	public static void printMap(boolean[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();

		}
		System.out.println("======================");
	}
}
