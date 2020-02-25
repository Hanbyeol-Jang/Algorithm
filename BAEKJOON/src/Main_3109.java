import java.util.Scanner;

public class Main_3109 {

	static int R, C;
	static char[][] map;
	static int[][] pipe;
	static boolean[][] visited;
	static int cnt;
	static boolean finish;

	static int[] dy = { -1, 0, 1 };
	static int[] dx = { 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		pipe = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();

			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x')
					pipe[i][j] = -1;
			}
		}

		for (int i = 0; i < R; i++) {
			finish = false;

			if (safe(i + dy[0], 0 + dx[0]) && safe(i + dy[1], 0 + dx[1]) && safe(i + dy[2], 0 + dx[2])
					&& (pipe[i + dy[0]][0 + dx[0]] != 1 || pipe[i + dy[1]][0 + dx[1]] != 1
							|| pipe[i + dy[2]][0 + dx[2]] != 1)) {
				dfs(i, 0);
				if (finish)
					cnt++;
			}

		}

		System.out.println(cnt);

	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < C && y >= 0 && y < R) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;
		pipe[y][x] = 1;
		
		if (x == C - 1) {
			finish = true;
		}

		for (int i = 0; i < 3; i++) {
			if (finish)
				return;
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] == '.' && !visited[y + dy[i]][x + dx[i]]) {
				visited[y + dy[i]][x + dx[i]] = true;

				dfs(y + dy[i], x + dx[i]);
			}
		}

	}

	public static void printMap(char[][] m) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("===========================");
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
