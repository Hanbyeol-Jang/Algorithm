import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfstest {

	public static int[][] map;
	public static boolean[][] visited;
	public static int N;
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static int area;
	public static int cnt;

	public static Queue<Point> que = new LinkedList<>();
	public static LinkedList<Integer> list = new LinkedList<>();

	public static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				if (visited[i][j]) {
					continue;
				}

				cnt = 0;
				que.add(new Point(i, j));
				area++;
				go();
				list.add(cnt);
				System.out.println(cnt);
			}
		}
		Collections.sort(list);

		System.out.println(area);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();

	}

	public static void go() {

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

					if (visited[ny][nx]) {
						continue;
					}

					if (map[ny][nx] == 0) {
						continue;
					}

					que.add(new Point(ny, nx));
					visited[ny][nx] = true;
					cnt++;
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

}
