package D1;

import java.util.Scanner;

public class Solution_2058 {

	static int N;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		while (N != 0) {
			sum += N % 10;
			N /= 10;
		}

		System.out.println(sum);

	}

}
