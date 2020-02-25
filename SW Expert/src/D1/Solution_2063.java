package D1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2063 {

	static int N;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);

		System.out.println(num[N / 2]);

	}
}
