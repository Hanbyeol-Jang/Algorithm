import java.util.Scanner;

public class Act {

	static int v, path;
	static int[][] map;
	static boolean[] visited;
	static int min;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		map = new int[v + 1][v + 1];
		visited = new boolean[v + 1];
		path = sc.nextInt();

		for (int i = 0; i < path; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int w = sc.nextInt();

			map[y][x] = w;
			map[x][y] = w;
		}

		min = Integer.MAX_VALUE;

		bfs(1, 0);

		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);

	}

	public static void bfs(int vertex, int w) {

		if (vertex == v) {
			if (min > w) {
				min = w;
				return;
			}
		}

		for (int i = 1; i <= v; i++) {
			if (map[vertex][i] != 0 && !visited[vertex]) {
				visited[vertex] = true;
				bfs(i, w + map[vertex][i]);
				visited[vertex] = false;
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
