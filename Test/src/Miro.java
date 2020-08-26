import java.util.Scanner;

public class Miro {

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int h, w, min;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();

		map = new int[h][w];

		for (int i = 0; i < h; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < w; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		min = Integer.MAX_VALUE;
		dfs(0, 0, 1);
	}

	public static void dfs(int y, int x, int cnt) {
		if (y == h - 1 && x == w - 1) {
			min = Math.min(min, cnt);
			return;
		}

		map[y][x] = 3;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!checked(ny, nx)) {
				continue;
			}
			if (map[ny][nx] == 1) {
				dfs(ny, nx, cnt + 1);
			}

		}
		map[y][x] = 1;
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < w && y >= 0 && y < h) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap() {

	}
}
