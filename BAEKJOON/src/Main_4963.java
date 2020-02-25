import java.util.Scanner;

public class Main_4963 {

	static int R, C;

	static int[][] map;
	static boolean[][] visited;

	static int cnt;

	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			C = sc.nextInt();
			R = sc.nextInt();

			if (R == 0 && C == 0)
				return;
			cnt = 0;
			map = new int[R][C];
			visited = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}

	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < C && y >= 0 && y < R) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x) {

		visited[y][x] = true;
		for (int i = 0; i < 8; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] == 1 && !visited[y + dy[i]][x + dx[i]]) {
				visited[y + dy[i]][x + dx[i]] = true;
				dfs(y + dy[i], x + dx[i]);
			}
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("===========================");
	}
}
