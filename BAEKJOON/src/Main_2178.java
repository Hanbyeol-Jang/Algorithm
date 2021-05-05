import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

	public static int N;
	public static int M;
	public static int[][] map;
	public static int[][] fill;
	public static boolean[][] visited;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

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
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		fill = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			char[] c = st.nextToken().toCharArray();

			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		fill[0][0] = 1;

		que.offer(new Point(0, 0));
		visited[0][0] = true;
		bfs();

		System.out.println(fill[N - 1][M - 1]);
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
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					if (!isSafe(ny, nx)) {
						continue;
					}

					if (map[ny][nx] != 1) {
						continue;
					}

					if (visited[ny][nx]) {
						continue;
					}

					que.offer(new Point(ny, nx));
					visited[ny][nx] = true;

					fill[ny][nx] = fill[cur.y][cur.x] + 1;

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
