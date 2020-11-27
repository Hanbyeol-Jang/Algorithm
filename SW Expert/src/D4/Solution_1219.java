package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1219 {

	public static int N;
	public static int[] left;
	public static int[] right;
	public static boolean[] visited;
	public static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			st.nextToken();

			N = Integer.parseInt(st.nextToken());

			left = new int[100];
			right = new int[100];

			Arrays.fill(left, -1);
			Arrays.fill(right, -1);

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				System.out.println(from + " " + to);

				if (left[from] == -1) {
					left[from] = to;
				} else {
					right[from] = to;
				}
			}

			visited = new boolean[100];
			flag = false;

			go(0);

			if (flag) {
				System.out.println("#" + test_case + " 1");

			} else {
				System.out.println("#" + test_case + " 0");
			}
		}

	}

	public static void go(int idx) {

		if (idx == 99) {
			flag = true;
			return;
		}

		if (!flag) {
			if ((left[idx] != -1) && (visited[left[idx]] == false)) {
				visited[left[idx]] = true;
				go(left[idx]);
				visited[left[idx]] = false;
			}

			if ((right[idx] != -1) && (visited[right[idx]] == false)) {
				visited[right[idx]] = true;
				go(right[idx]);
				visited[right[idx]] = false;
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
