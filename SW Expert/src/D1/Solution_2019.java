package D1;

import java.util.Scanner;

public class Solution_2019 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i <= N; i++) {
			System.out.print(Math.round(Math.pow(2, i)) + " ");
		}
	}

}
