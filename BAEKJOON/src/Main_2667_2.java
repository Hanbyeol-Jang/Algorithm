import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_2667_2 {

	public static int n;
	public static int[][] map;
	public static int cave;
	public static boolean[][] visited;
	public static int cnt;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static LinkedList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		map = new int[n][n];
		visited = new boolean[n][n];

		list = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			String c = sc.next();

			for (int j = 0; j < n; j++) {
				map[i][j] = c.charAt(j) - '0';
			}
		}

//		printMap(map);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}

				if (map[i][j] != 1) {
					continue;
				}

				cnt = 0;
				dfs(i, j, cnt);
				cave++;
				list.add(cnt);
			}
		}

		System.out.println(cave);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < n && y >= 0 && y < n) {
			return true;
		} else {
			return false;
		}
	}

	public static void dfs(int y, int x, int count) {
		visited[y][x] = true;
		cnt++;

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
			dfs(ny, nx, cnt);

		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
	}

}
