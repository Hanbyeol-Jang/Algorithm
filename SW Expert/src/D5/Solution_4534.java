package D5;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4534 {

	static int TestCase;
	static int N;
	static int MOD = 1000000007;
	static ArrayList<Integer>[] list;

	static long[][] memo; // 정점 번호, 색상

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			list = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			memo = new long[N + 1][2];

			for (int i = 1; i < N; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();

				list[y].add(x);
				list[x].add(y);
			}

			long ans = (dfs(1, 0, -1) + dfs(1, 1, -1)) % MOD;
			System.out.println("#" + T + " " + ans);

		}
	}

	public static long dfs(int v, int color, int parent) {
		// memo[v][color] 존재하면 다시 계산X, 값 return
		if (memo[v][color] != 0) { 
			return memo[v][color];
		}

		long cnt = 1;

		// color 흑 0
		// 자식 노드 백 1

		if (color == 0) {
			for (int i = 0; i < list[v].size(); i++) {
				if (list[v].get(i) == parent)
					continue;
				
				cnt *= dfs(list[v].get(i), 1, v);
				cnt %= MOD;
			}
		}

		// color 백 1
		// 자식 노드 흑 0
		// +
		// 자식 노드 백 1

		else {
			for (int i = 0; i < list[v].size(); i++) {
				if (list[v].get(i) == parent)
					continue;

				cnt *= dfs(list[v].get(i), 1, v) + dfs(list[v].get(i), 0, v);
				cnt %= MOD;
			}

		}
		
		// memo[v][color] 에 기록
		memo[v][color] = cnt;
		return cnt;
	}

}
