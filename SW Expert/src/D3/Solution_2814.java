package D3;

import java.util.Scanner;

public class Solution_2814 {

	static int TestCase;
	static int N, M;
	static int[][] map;
	static boolean[] visited;

	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N + 1][N + 1];
			visited = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				map[x][y] = 1;
				map[y][x] = 1;
			}

			max = Integer.MIN_VALUE;

			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + T + " " + max);

		}
	}

	public static void dfs(int v, int cnt) {
		max = Math.max(max, cnt);

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && map[v][i] != 0) {
				visited[v] = true;
				dfs(i, cnt + 1);
				visited[v] = false;
			}
		}

	}
}
