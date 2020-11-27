
public class Solution_네트워크 {

	// https://programmers.co.kr/learn/courses/30/lessons/43162
	public static void main(String[] args) {
		int n = 6;
		int[][] computers = { { 1, 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1 }, { 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1 } };

		System.out.println(solution(n, computers));
	}

	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };
	public static int N;

	public static int solution(int n, int[][] computers) {
		N = n;
		map = new int[N][N];
		visited = new boolean[N][N];
		map = computers;

		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}

				if (map[i][j] != 1) {
					continue;
				}

				go(i, j);
				answer++;

			}
		}

		return answer;
	}

	public static void go(int y, int x) {
		if (visited[y][x]) {
			return;
		}

		visited[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!checked(ny, nx)) {
				continue;
			}

			if (map[ny][nx] != 1) {
				continue;
			}

			go(ny, nx);

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
		System.out.println("=============================");
	}
}
