import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2667_3 {

	public static int N;
	public static int[][] map;
	public static boolean[][] visited;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static Queue<Point> que;
	public static LinkedList<Integer> list;
	public static int cnt;
	public static int cave;

	public static class Point {
		int y;
		int x;
		int count;

		Point(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String c = sc.next();

			for (int j = 0; j < N; j++) {
				map[i][j] = c.charAt(j) - '0';
			}
		}

//		printMap(map);

		que = new LinkedList<>();
		list = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 1) {
					continue;
				}

				if (visited[i][j]) {
					continue;
				}

				cnt = 0;
				que.add(new Point(i, j, 1));
				bfs(i, j, 1);
				cave++;
				list.add(cnt);

			}
		}

		System.out.println(cave);

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static void bfs(int y, int x, int c) {

		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				Point now = que.poll();

				for (int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];

					if (!checked(ny, nx)) {
						continue;
					}

					if (map[ny][nx] == 0) {
						continue;
					}

					if (visited[ny][nx]) {
						continue;
					}

					cnt++;

					que.add(new Point(ny, nx, cnt));
					visited[ny][nx] = true;
				}

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
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}
}
