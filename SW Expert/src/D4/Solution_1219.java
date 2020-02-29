package D4;

import java.util.Scanner;

public class Solution_1219 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int max;

	static int A = 0;
	static int B = 99;
	static int fin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T <= 1; T++) {
			int t = sc.nextInt();
			N = sc.nextInt();
			map = new int[N + 1][N + 1];

			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				int source = sc.nextInt();
				int dest = sc.nextInt();

				if (dest != 99) {
					map[source][dest] = 1;
					map[dest][source] = 1;

					if (max < source) {
						max = source;
					}
					if (max < dest) {
						max = dest;
					}
					continue;
				} else {
					fin = source;
				}

			}

			visited = new boolean[max + 1];
			System.out.println(max);
			dfs(0);

			for (int i = 0; i <= max; i++) {
				System.out.println(i + " " + visited[i] + " ");
			}

			printMap(map);
		}
	}

	public static void dfs(int v) {
		if (v == B) {
			return;
		}

		System.out.println("ddd");
		for (int i = 0; i <= fin; i++) {
			if (map[v][i] != 0 && !visited[v]) {
				visited[v] = true;
				dfs(i);
				visited[v] = false;
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
		System.out.println("================");
	}
}
