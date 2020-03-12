package D2;

import java.util.Scanner;

public class Solution_1959 {

	static int TestCase;
	static int N, M;
	static int[] A;
	static int[] B;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			M = sc.nextInt();
			A = new int[N];
			B = new int[M];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}

			max = Integer.MIN_VALUE;

			if (N > M) {
				AA();
			} else if (N < M) {
				BB();
			} else {
				eq();
			}

			System.out.println("#" + T + " " + max);
		}
	}

	public static void AA() {
		int move = 0;

		while (true) {
			if (move + M > N) {
				break;
			}

			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += A[i + move] * B[i];
			}

			max = Math.max(max, sum);
			move++;
		}

	}

	public static void BB() {
		int move = 0;

		while (true) {
			if (move + N > M) {
				break;
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += A[i] * B[i + move];
			}

			max = Math.max(max, sum);
			move++;
		}
	}

	public static void eq() {
		int sum = 0;
		for (int i = 0; i < M; i++) {
			sum += A[i] * B[i];
		}
		max = sum;
	}
}
