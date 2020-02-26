import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4179_2 {

	static int R, C;
	static char[][] map;
	static int[][] visitedJ;
	static boolean[][] visited;

	static int minute;

	static int Sy, Sx;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static Queue<int[]> que;
	static LinkedList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R + 2][C + 2];
		visitedJ = new int[R + 2][C + 2];

		for (int i = 0; i < R; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i + 1][j + 1] = c[j];
			}
		}

		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				if (i == 0 || i == R + 1) {
					map[i][j] = 'O';
					continue;
				}

				if (j == 0 || j == C + 1) {
					map[i][j] = 'O';
					continue;
				}

				if (map[i][j] == 'J') {
					Sy = i;
					Sx = j;
					visitedJ[i][j] = 1;
					continue;
				}

			}
		}

		que = new LinkedList<int[]>();
		list = new LinkedList<>();
		que.offer(new int[] { Sy, Sx });

//		printMap(visitedJ);
//		printMap(map);

		while (!que.isEmpty()) {
			visited = new boolean[R + 2][C + 2];

			int[] temp = que.poll();

			if (map[temp[0]][temp[1]] == 'O') {
				break;
			}

			for (int i = 1; i < R + 1; i++) {
				for (int j = 1; j < C + 1; j++) {
					if (map[i][j] == 'F' && !visited[i][j]) {
						visited[i][j] = true;
						fire(i, j);

					}
				}
			}

			move(temp[0], temp[1]);

//			printMap(visitedJ);
//			printMap(map);

		}

		Collections.sort(list);
//		for (int k = 0; k < list.size(); k++) {
//			System.out.print(list.get(k) + " ");
//		}
//		System.out.println();
		if (list.isEmpty()) {
			System.out.println("IMPOSSIBLE");
		} else
			System.out.println(list.get(0));

	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < C + 2 && y >= 0 && y < R + 2) {
			return true;
		} else
			return false;
	}

	public static void move(int y, int x) {

		for (int i = 0; i < 4; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] != '#' && map[y + dy[i]][x + dx[i]] != 'F'
					&& visitedJ[y + dy[i]][x + dx[i]] == 0) {

				if (map[y + dy[i]][x + dx[i]] == 'O') {
					list.add(visitedJ[y][x]);
					return;
				}
//
//				map[y][x] = '.';
//				map[y + dy[i]][x + dx[i]] = 'J';

				visitedJ[y + dy[i]][x + dx[i]] = visitedJ[y][x] + 1;
				que.offer(new int[] { y + dy[i], x + dx[i] });
				System.out.println((y + dy[i]) + " " + (x + dx[i]));
			}
		}
	}

	public static void fire(int y, int x) {

		for (int i = 0; i < 4; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] != 'O' && map[y + dy[i]][x + dx[i]] != '#'
					&& !visited[y + dy[i]][x + dx[i]]) {
				if (map[y + dy[i]][x + dx[i]] == 'F') {
					continue;
				}
				visited[y + dy[i]][x + dx[i]] = true;
				map[y + dy[i]][x + dx[i]] = 'F';

			}
		}

	}

	public static void printMap(char[][] m) {
		for (int i = 0; i <= R + 1; i++) {
			for (int j = 0; j <= C + 1; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("===========================");
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i <= R + 1; i++) {
			for (int j = 0; j <= C + 1; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("===========================");
	}

}
