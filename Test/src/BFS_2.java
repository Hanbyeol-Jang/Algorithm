import java.util.LinkedList;
import java.util.Queue;

public class BFS_2 {

	static int[][] map;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int N;
	static int ans;

	public static void main(String[] args) {

	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;

		int dist = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			// 출발점에서 같은 거리에 있는 좌표들을 빼냄 (Queue의 모든 좌표를 빼는게 아님)
			for (int i = 0; i < size; i++) {
				Point now = queue.poll();

				if (now.y == N - 1 && now.x == N - 1) {
					ans = dist;
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];

					if (!checked(ny, nx))
						continue;
					if (map[ny][nx] != 0)
						continue;
					if (visited[ny][nx])
						continue;

					queue.add(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			} // 거리가 같은 좌표들이 한번 싹 처리됨

			dist++;

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
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
