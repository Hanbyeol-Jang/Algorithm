import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {

	public static int n;
	public static int[][] map;
	public static boolean[][] visited;
	public static int cave;
	public static int count;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		printMap(map);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}

				if (map[i][j] == 1) {
					cave++;
					count = 0;
					dfs(i, j, count);
					list.add(count);
				}
			}
		}

		Collections.sort(list, Collections.reverseOrder());

		System.out.println(cave);
		for (int i = 0; i < cave; i++) {
			System.out.println(list.get(i));
		}

	}

	public static void dfs(int y, int x, int cnt) {

		visited[y][x] = true;
		count++;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!checked(ny, nx)) {
				continue;
			}

			if (visited[ny][nx]) {
				continue;
			}

			if (map[ny][nx] != 1) {
				continue;
			}

			visited[ny][nx] = true;
			dfs(ny, nx, count);
		}

	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < n && y >= 0 && y < n) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("============================");
	}

}
