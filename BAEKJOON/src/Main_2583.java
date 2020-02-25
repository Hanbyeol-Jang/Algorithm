import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_2583 {

	static int M, N, K;
	static int[][] map;
	static int Sy, Sx, Ey, Ex;
	static int len;
	static int cnt;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];
		K = sc.nextInt();

		for (int k = 0; k < K; k++) {
			Sx = sc.nextInt();
			Sy = sc.nextInt();
			Ex = sc.nextInt();
			Ey = sc.nextInt();

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (i >= Sy && i < Ey && j >= Sx && j < Ex) {
						map[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				len = 0;
				if (map[i][j] == 0) {
					cnt++;
					dfs(i, j);
					list.add(len);
				}
			}
		}

		Collections.sort(list);
		System.out.println(cnt);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x) {
		len++;
		map[y][x] = len;

		for (int i = 0; i < 4; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] == 0) {
				dfs(y + dy[i], x + dx[i]);
			}
		}

	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

}
