import java.util.Collections;
import java.util.LinkedList;

public class Solution_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		System.out.println(solution(m, n, picture)[0] + " " + solution(m, n, picture)[1]);
	}

//	public static int m = 13;
//	public static int n = 16;
//	public static int[][] picture ={{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
//			 {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
//			 {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, 
//			 {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, 
//			 {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, 
//			 {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, 
//			 {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
//			 {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
//			 {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
//			 {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
//			 {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static boolean[][] visited;
	public static int cnt;

	public static int[][] map;
	public static LinkedList<Integer> list = new LinkedList<>();
	public static int M, N;

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		M = m;
		N = n;

		list.clear();
		map = picture;

		visited = new boolean[M][N];

//		printMap(picture);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] == 0) {
					continue;
				}

				if (visited[i][j]) {
					continue;
				}

				numberOfArea++;
				dfs(i, j, 0);
//				System.out.println(cnt);
				list.add(cnt);
				cnt = 0;
			}
		}

		Collections.sort(list);
//		System.out.println(list.get(list.size() - 1));
		maxSizeOfOneArea = list.get(list.size() - 1);
//		System.out.println(numberOfArea);
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
//		System.out.println(numberOfArea);

		return answer;
	}

	public static void dfs(int y, int x, int c) {

//		System.out.println("y: " + y + " x: " + x);

		int temp = map[y][x];

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!checked(ny, nx)) {
				continue;
			}

			if (map[ny][nx] == 0) {
				continue;
			}

			if (visited[ny][nx]) {
				continue;
			}

			if (temp != map[ny][nx]) {
				continue;
			}

			cnt++;
			visited[ny][nx] = true;
			dfs(ny, nx, cnt);
		}

	}

	public static boolean checked(int y, int x) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("================");
	}

}
