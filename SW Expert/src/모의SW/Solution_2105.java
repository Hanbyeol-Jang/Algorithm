package 모의SW;

import java.util.HashSet;
import java.util.Scanner;

public class Solution_2105 {

	static int TestCase;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static HashSet<Integer> list = new HashSet<>();

	static int Sy, Sx;

	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { 1, -1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			map = new int[N][N];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					list.clear();
					visited = new boolean[N][N];
					Sy = i;
					Sx = j;

					dfs(i, j, 0);
				}
			}

			if (max == Integer.MIN_VALUE) {
				System.out.println("#" + T + " -1");
			} else {
				System.out.println("#" + T + " " + max);

			}

		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x, int d) {
		visited[y][x] = true;
		list.add(map[y][x]);

		for (int i = d; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			int cnt = list.size();

			if (Sy == ny && Sx == nx && cnt >= 4) {
				if (cnt > max) {
					max = cnt;
					return;
				}
			}

			if (!safe(ny, nx))
				continue;

			if (visited[ny][nx])
				continue;

			if (list.contains(map[ny][nx]))
				continue;

			dfs(ny, nx, i);
		}

		visited[y][x] = false;
		list.remove(map[y][x]);

	}

}
