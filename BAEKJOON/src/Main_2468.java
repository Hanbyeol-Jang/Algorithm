import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {

	public static int N;

	public static int[][] map;
	public static boolean[][] visited;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static int max;
	public static int H;

	public static Queue<Point> que = new LinkedList<>();

	public static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		int answer = 1;

		for (int h = 1; h < max; h++) {
			H = h;
			visited = new boolean[N][N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) {
						continue;
					}

					if (map[i][j] <= h) {
						continue;
					}

					visited[i][j] = true;
					que.add(new Point(i, j));
					cnt++;
					find();
				}
			}

			answer = Math.max(answer, cnt);
		}

		System.out.println(answer);
	}

	public static void find() {

		while (!que.isEmpty()) {
			Point cur = que.poll();

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];

				if (!checked(ny, nx)) {
					continue;
				}

				if (visited[ny][nx]) {
					continue;
				}

				if (map[ny][nx] <= H) {
					continue;
				}

				visited[ny][nx] = true;

				que.add(new Point(ny, nx));
			}

		}

	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("============");
	}
}
