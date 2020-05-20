package D5;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_7396 {
	static int TestCase;
	static int N, M;
	static char[][] map;
	static boolean[][] visited;

	static int[] dy = { 1, 0 };
	static int[] dx = { 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new char[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}

			System.out.print("#" + T + " ");
			bfs();
			System.out.println();
		}

	}

	public static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		LinkedList<Point> list = new LinkedList<>();

		pq.add(new Point(0, 0, map[0][0])); // 출발점
		visited[0][0] = true;
		while (!pq.isEmpty()) {
			list.clear();
			int size = pq.size();

			Point first = pq.peek();

			for (int s = 0; s < size; s++) {
				Point now = pq.poll();
				if (first.ch == now.ch) {
					for (int i = 0; i < 2; i++) {
						int ny = now.y + dy[i];
						int nx = now.x + dx[i];

						if (!checked(ny, nx))
							continue;
						if (visited[ny][nx])
							continue;

						list.add(new Point(ny, nx, map[ny][nx]));
						visited[ny][nx] = true;
					}
				} else {
					break;
				}
			}
			System.out.print(first.ch);
			pq.clear();
			pq.addAll(list);
		}
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < M && y >= 0 && y < N) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(char[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

	static class Point implements Comparable<Point> {
		int y, x;
		char ch;

		Point(int y, int x, char ch) {
			this.y = y;
			this.x = x;
			this.ch = ch;
		}

		@Override
		public int compareTo(Point o) {
			return this.ch - o.ch;
		}
	}

}
