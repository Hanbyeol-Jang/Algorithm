package D4;

import java.util.Scanner;

public class Solution_3347 {

	static int TestCase;
	static int N, M;
	static int[] Ai;
	static int[] Bi;
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			M = sc.nextInt();

			Ai = new int[N];
			Bi = new int[M];
			cnt = new int[N];

			for (int i = 0; i < N; i++) {
				Ai[i] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				Bi[i] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (Bi[i] >= Ai[j]) {
						cnt[j]++;
						break;
					}
				}
			}

			int max = Integer.MIN_VALUE;
			int loc = 0;

			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] > max) {
					max = cnt[i];
					loc = i;
				}
			}
			loc++;

			System.out.println("#" + T + " " + loc);

		}

	}

}