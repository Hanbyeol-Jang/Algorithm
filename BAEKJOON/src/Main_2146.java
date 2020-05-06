import java.util.Scanner;

public class Main_2146 {

	static int N;
	static int[][] map;
	static int[][] bridgeNum;
	static boolean[][] visited;
	static int cnt;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		bridgeNum = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;

				if (map[i][j] == 1) {
					cnt++;
					bridgeNum[i][j] = cnt;

					bridgeCnt(i, j);
				}
			}
		}

		printMap(bridgeNum);

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				for (int k = 0; k < 4; k++) {
//					int ny = i + dy[k];
//					int nx = j + dx[k];
//
//					if (!checked(ny, nx))
//						continue;
//
//					if (map[i][j] == 1 && map[ny][nx] == 0) {
//						cnt = 0;
//						dfs(ny, nx);
//					}
//				}
//			}
//		}

	}

	public static void bridgeCnt(int y, int x) {
		if (visited[y][x]) {
			return;
		}

		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!checked(ny, nx))
				continue;

			if (visited[ny][nx])
				continue;

			if (map[ny][nx] == 0)
				continue;

			bridgeNum[ny][nx] = cnt;

			bridgeCnt(ny, nx);
		}
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		} else
			return false;
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}
}
