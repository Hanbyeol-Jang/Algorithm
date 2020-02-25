package D4;

import java.util.Scanner;

public class Solution_1226 {

	static int[][] map;
	static char[] temp;
	static boolean[][] visited;

	static int Sy, Sx, Ey, Ex, Fy, Fx;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int T = 1; T <= 10; T++) {
			T = sc.nextInt();
			map = new int[16][16];
			temp = new char[16];
			visited = new boolean[16][16];

			for (int i = 0; i < 16; i++) {
				temp = sc.next().toCharArray();

				for (int j = 0; j < 16; j++) {
					map[i][j] = (int) temp[j] - 48;
				}
			}

			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if (map[i][j] == 2) {
						Sy = i;
						Sx = j;
						continue;
					}
					if (map[i][j] == 3) {
						Ey = i;
						Ex = j;
					}
				}
			}

//			printMap(map);

			dfs(Sy, Sx);

			if (Ey == Fy && Ex == Fx) {
				System.out.println("#" + T + " 1");
			} else
				System.out.println("#" + T + " 0");

		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < 16 && y >= 0 && y < 16) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x) {

		for (int i = 0; i < 4; i++) {
			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] == 3) {
				Fy = y + dy[i];
				Fx = x + dx[i];
				return;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (safe(y + dy[i], x + dx[i]) && !visited[y + dy[i]][x + dx[i]] && map[y + dy[i]][x + dx[i]] == 0) {
				visited[y + dy[i]][x + dx[i]] = true;
				dfs(y + dy[i], x + dx[i]);
				visited[y + dy[i]][x + dx[i]] = false;
			}
		}

	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("====================");
	}
}
