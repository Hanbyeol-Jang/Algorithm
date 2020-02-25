package D4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_7733 {

	static int TestCase;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int max;

	static LinkedList<Integer> list;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			map = new int[N][N];
			list = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int day = 0; day <= 100; day++) {
				visited = new boolean[N][N];
				cnt = 0;

				if (day != 0) {
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if (map[i][j] == day) {
								map[i][j] = 0;
							}
						}
					}
				}
				
				godfs();

				list.add(cnt);
				continue;

			}

			int max = 1;

			Collections.sort(list, Collections.reverseOrder());
			if (list.get(0) > max) {
				max = list.get(0);
			}

			System.out.println("#" + T + " " + max);

		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x) {

		for (int i = 0; i < 4; i++) {
			if (safe(y + dy[i], x + dx[i]) && !visited[y + dy[i]][x + dx[i]] && map[y + dy[i]][x + dx[i]] != 0) {
				visited[y + dy[i]][x + dx[i]] = true;
				dfs(y + dy[i], x + dx[i]);
			}
		}
	}

	public static void godfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] != 0 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}

			}
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("===========================");
	}

}
