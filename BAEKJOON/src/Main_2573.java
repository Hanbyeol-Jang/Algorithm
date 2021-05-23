import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 {
	public static int N;
	public static int M;

	public static int[][] map;
	public static boolean[][] visited;

	public static int[] dy = { 0, -1, 0, 1 };
	public static int[] dx = { -1, 0, 1, 0 };

	public static Queue<Point> que = new LinkedList<>();
	public static Queue<Point> meltList = new LinkedList<>();

	public static class Point {
		int y;
		int x;
		int cnt;

		Point(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		int island = 0;

		while (true) {
			if (fullZero(map)) {
				year = 0;
				break;
			}

			island = 0;

			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						continue;
					}

					if (map[i][j] == 0) {
						continue;
					}

					que.offer(new Point(i, j, 0));
					visited[i][j] = true;
					check();

					island++;
				}
			}

			if (island >= 2) {
				break;
			}
			melt();

			year++;
		}

		System.out.println(year);
	}

	public static boolean isSafe(int y, int x) {
		if (x >= 0 && x < M && y >= 0 && y < N) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean fullZero(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	public static void melt() {
		while (!meltList.isEmpty()) {
			int size = meltList.size();

			for (int i = 0; i < size; i++) {
				Point cur = meltList.poll();

				int temp = map[cur.y][cur.x];

				if (temp - cur.cnt > 0) {
					map[cur.y][cur.x] = temp - cur.cnt;

				} else {
					map[cur.y][cur.x] = 0;
				}
			}
		}
	}

	public static void check() {
		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				Point cur = que.poll();
				int zeroCnt = 0;

				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					if (!isSafe(ny, nx)) {
						continue;
					}

					if (map[ny][nx] == 0) {
						zeroCnt++;
					}
				}

				meltList.offer(new Point(cur.y, cur.x, zeroCnt));

				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					if (!isSafe(ny, nx)) {
						continue;
					}

					if (visited[ny][nx]) {
						continue;
					}

					if (map[ny][nx] == 0) {
						continue;
					}

					que.offer(new Point(ny, nx, 0));
					visited[ny][nx] = true;
				}
			}
		}
	}

}