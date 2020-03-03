package D4;

import java.util.Scanner;

public class Solution_7699 {

	static int TestCase;
	static int R, C;
	static int[][] map;
	static boolean[] visited;
	static int max;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new int[R][C];
			visited = new boolean[26];

			for (int i = 0; i < R; i++) {
				String s = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j) - 'A';
				}
			}

			max = Integer.MIN_VALUE;
			dfs(0, 0, 1);
			System.out.println("#" + T + " " + max);
		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < C && y >= 0 && y < R) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x, int cnt) {
		max = Math.max(max, cnt);
		visited[map[y][x]] = true;

		for (int i = 0; i < 4; i++) {
			if (!safe(y + dy[i], x + dx[i]))
				continue;
			if (visited[map[y + dy[i]][x + dx[i]]])
				continue;

			if (safe(y + dy[i], x + dx[i]) && !visited[map[y + dy[i]][x + dx[i]]]) {
				visited[map[y + dy[i]][x + dx[i]]] = true;
				dfs(y + dy[i], x + dx[i], cnt+1);
				visited[map[y + dy[i]][x + dx[i]]] = false;
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
		System.out.println("===============================");
	}
}
