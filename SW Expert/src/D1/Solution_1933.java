package D1;

import java.util.Scanner;

public class Solution_1933 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				System.out.print(i + " ");
			}
		}

	}

}
