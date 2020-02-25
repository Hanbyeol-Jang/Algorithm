import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2667 {

	static int N;
	static String s;
	static char[][] temp;
	static int[][] map;
	static int cnt;
	static int cave;
	static ArrayList<Integer> list = new ArrayList<>();

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		temp = new char[N][N];
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			s = sc.next();
			temp[i] = s.toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = (int) temp[i][j] - 48;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					dfs(i, j, cnt + 1);
					list.add(cave);
					cave = 0;
				}

			}
		}

//		printMap(map);

		System.out.println(cnt);

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static boolean safe(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		} else
			return false;
	}

	public static void dfs(int y, int x, int c) {
		cave++;
		map[y][x] = c;

		for (int i = 0; i < 4; i++) {

			if (safe(y + dy[i], x + dx[i]) && map[y + dy[i]][x + dx[i]] == 1) {
				dfs(y + dy[i], x + dx[i], c);
			}
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("========================");

	}
}
