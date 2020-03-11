package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1966 {

	static int TestCase;
	static int N;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}

			Arrays.sort(num);

			System.out.print("#" + T + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
	}
}
