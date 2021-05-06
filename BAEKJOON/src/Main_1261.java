import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {

	public static int M;
	public static int N;
	public static int[][] map;
	public static boolean[][] visited;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static int dist;

	public static PriorityQueue<Point> que = new PriorityQueue<>((o1, o2) -> {
		if (o1.cnt > o2.cnt) {
			return 1;
		} else if (o1.cnt < o2.cnt) {
			return -1;
		}

		return 0;
	});

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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			char[] c = st.nextToken().toCharArray();

			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		dist = 0;
		visited[0][0] = true;
		que.offer(new Point(0, 0, 0));

		bfs();

	}

	public static boolean isSafe(int y, int x) {
		if (x >= 0 && x < M && y >= 0 && y < N) {
			return true;
		} else {
			return false;
		}
	}

	public static void bfs() {

		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				Point cur = que.poll();

				if (cur.y == N - 1 && cur.x == M - 1) {
					System.out.println(cur.cnt);
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					if (!isSafe(ny, nx)) {
						continue;
					}

					if (visited[ny][nx]) {
						continue;
					}

					visited[ny][nx] = true;

					if (map[ny][nx] == 0) {
						que.offer(new Point(ny, nx, cur.cnt));
					} else {
						que.offer(new Point(ny, nx, cur.cnt + 1));
					}

				}

			}

		}

	}

	public static void printArr(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}
}
