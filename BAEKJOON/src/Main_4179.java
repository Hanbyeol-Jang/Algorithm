import java.util.LinkedList;
import java.util.Scanner;

public class Main_4179 {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] visitedJ;

	static int minute;
	static boolean finish;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R + 2][C + 2];

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
				}

				if (j == 0 || j == C + 1) {
					map[i][j] = 'O';
				}
			}
		}
//		System.out.println(minute);
//		printMap(map);
		for (minute = 1; minute <= 10; minute++) {

			visited = new boolean[R + 2][C + 2];
			visitedJ = new boolean[R + 2][C + 2];

			for (int i = 1; i < R + 1; i++) {
				for (int j = 1; j < C + 1; j++) {

					if (map[i][j] == 'J' && !visitedJ[i][j]) {
						visitedJ[i][j] = true;
						move(i, j);
					}
				}
			}

			if (finish) {
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

//			System.out.println(minute);
//			printMap(map);

		}

		if (minute == 1001) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(minute);
		}

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
					&& !visitedJ[y + dy[i]][x + dx[i]]) {

				if (map[y + dy[i]][x + dx[i]] == 'O') {
					finish = true;
//					System.out.println("종료 " + minute);
					return;
				}

				map[y][x] = '.';
				map[y + dy[i]][x + dx[i]] = 'J';
				visitedJ[y + dy[i]][x + dx[i]] = true;
				return;
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

	public static void printMap(boolean[][] m) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println("===========================");
	}
}
