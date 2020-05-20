package D4;

import java.util.Scanner;

public class Soluion_4796 {

	static int TestCase;
	static int N;
	static int[] h;

	static int[] num;
	static int[] arr = { 9, 10, 13, 15, 18, 19, 25, 26, 36, 41, 43, 45 };
	static int cnt;

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		TestCase = sc.nextInt();
//
//		for (int T = 1; T <= TestCase; T++) {
//			N = sc.nextInt();
//			h = new int[N];
//			for (int i = 0; i < N; i++) {
//				h[i] = sc.nextInt();
//			}
//
//		}

		num = new int[6];
		combi(12, 6, 0, 0);
		System.out.println("======");
		System.out.println(cnt);
		System.out.println(arr.length);
	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			cnt++;

			if (arr[num[0] - 1] < 10) {
				System.out.print(arr[num[0] - 1] + " ");
				for (int i = 1; i < num.length; i++) {

					System.out.print(arr[num[i] - 1] + " ");
				}
				System.out.println();
			}

			return;
		}

		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi(n, r, i + 1, count + 1);
		}
	}

}
