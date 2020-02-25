package D3;

import java.util.Scanner;

public class Solution_3376 {

	static int TestCase;
	static int N;
	static long[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			p = new long[N + 5];
	
			System.out.println("#" + T + " " + tri(N));

		}
	}

	public static long tri(int n) {
		p[0] = 1L;
		p[1] = 1L;
		p[2] = 1L;
		p[3] = 2L;
		p[4] = 2L;
		p[5] = 3L;

		for (int i = 5; i < n; i++) {
			p[i] = p[i - 1] + p[i - 5];
		}

		return p[n-1];
	}
}
