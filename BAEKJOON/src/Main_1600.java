import java.util.Scanner;

public class Main_1600 {

	public static int[][] map;
	public static boolean[][] visited;
	public static int K, W, H;

	public static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };

	public static int[] dyK = { -1, 0, 1, 0 };
	public static int[] dxK = { 0, 1, 0, -1 };

	public static boolean endK;
	public static int cnt;
	public static boolean answer;
	public static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][W];
		visited = new boolean[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		endK = false;
		answer = false;
		min = Integer.MAX_VALUE;

		go(0, 0);

//		printArr(map);

		if (answer) {
			System.out.println(min);
		} else {
			System.out.println(-1);
		}

	}

	public static void go(int y, int x) {
		System.out.println(y + " " + x);
		visited[y][x] = true;

		if (cnt == K) {
			endK = true;
		}

		if (y == H - 1 && x == W - 1) {
			answer = true;
			min = Math.min(min, cnt);

			return;
		}

		if (endK) {
			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (!checked(ny, nx)) {
					continue;
				}

				if (visited[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == 1) {
					continue;
				}

				cnt++;
				go(ny, nx);
				cnt--;
			}
		} else {
			for (int d = 0; d < 4; d++) {
				int ny = y + dyK[d];
				int nx = x + dxK[d];

				if (!checked(ny, nx)) {
					continue;
				}

				if (visited[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == 1) {
					continue;
				}

				cnt++;
				go(ny, nx);
				cnt--;
			}
		}
	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < W && y >= 0 && y < H) {
			return true;
		} else {
			return false;
		}
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=======================");
	}
}
