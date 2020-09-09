import java.util.LinkedList;
import java.util.Queue;

public class Solution_보행자천국 {

	public static void main(String[] args) {
//		int m = 3;
//		int n = 3;
//		int[][] cityMap = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		int m = 3;
		int n = 6;
		int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };

		System.out.println(solution(m, n, cityMap));
	}

	public static int MOD = 20170805;

	// 0 : 자유롭게
	// 1 : 금지
	// 2 : 좌회전, 우회전 X

	public static int M, N;
	public static int[][] map;
	public static int[][] mapCnt;
	public static boolean[][] visited;
	public static int[] dy = { 1, 0 };
	public static int[] dx = { 0, 1 };
	public static Queue<Point> que;

	public static class Point {
		int y;
		int x;
		int v;

		Point(int y, int x, int v) {
			this.y = y;
			this.x = x;
			this.v = v;
		}
	}

	public static int solution(int m, int n, int[][] cityMap) {
		M = m;
		N = n;
		map = cityMap;
		mapCnt = new int[M][N];
		visited = new boolean[M][N];
		que = new LinkedList<Point>();
		que.add(new Point(0, 0, 1));
		mapCnt[0][0] = 1;

		bfs();
		int answer = mapCnt[M - 1][N - 1];
		return answer % MOD;
	}

	public static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				Point now = que.poll();
				int temp = map[now.y][now.x];

				if (temp == 2) {
					mapCnt[now.y][now.x]--;
				}

				for (int d = 0; d < 2; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];

					if (!checked(ny, nx)) {
						continue;
					}

					if (visited[ny][nx]) {
						continue;
					}

					if (map[ny][nx] == 1) {
						continue;
					}

					visited[ny][nx] = true;

					if (!checked(ny - 1, nx)) {
						mapCnt[ny][nx] = mapCnt[ny][nx - 1];
					} else if (!checked(ny, nx - 1)) {
						mapCnt[ny][nx] = mapCnt[ny - 1][nx];
					} else {
						mapCnt[ny][nx] = mapCnt[ny - 1][nx] + mapCnt[ny][nx - 1];
					}

//					printMap(mapCnt);
					que.add(new Point(ny, nx, 0));
//					} // else

				} // d

			} // for size

		} // while
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(int[][] mm) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mm[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

}
