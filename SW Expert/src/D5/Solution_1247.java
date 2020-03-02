package D5;

import java.util.Scanner;

public class Solution_1247 {

	static int TestCase;
	static int N; // 고객의 수
	static int Cx, Cy, Hx, Hy;
	static int[][] customer;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			customer = new int[N][2]; // [i][0]: x좌표, [i][1]: y좌표

			Cx = sc.nextInt();
			Cy = sc.nextInt();
			Hx = sc.nextInt();
			Hy = sc.nextInt();

			for (int i = 0; i < N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			}

			min = Integer.MAX_VALUE;
			// 회사 위치가 시작, 이동거리는 0
			perm(0, 0, Cx, Cy, 0);
			System.out.println("#" + T + " " + min);

		}
	}

	public static void perm(int flag, int count, int Bx, int By, int result) {

		if (result >= min)
			return;

		if (count == N) {
			result += Math.abs(Bx - Hx) + Math.abs(By - Hy);
			if (min > result) {
				min = result;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {

				perm(flag | 1 << i, count + 1, customer[i][0], customer[i][1],
						result + Math.abs(Bx - customer[i][0]) + Math.abs(By - customer[i][1]));
			}

		}

	}
}
