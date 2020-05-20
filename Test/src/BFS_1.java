import java.util.LinkedList;
import java.util.Queue;

public class BFS_1 {

	static int[][] map;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int N;
	static int ans;

	public static void main(String[] args) {

	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true; // 출발점은 이미 Queue에 들어감

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.y == N - 1 && now.x == N - 1) {
				ans = now.dist;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (!checked(ny, nx))
					continue;
				if (map[ny][nx] != 0)
					continue;
				if (visited[ny][nx])
					continue;

				queue.add(new Point(ny, nx, now.dist + 1));
				visited[ny][nx] = true;
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

	static class Point {
		int y, x, dist;

		Point(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
}
