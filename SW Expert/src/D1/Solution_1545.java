package D1;

import java.util.Scanner;

public class Solution_1545 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = N; i >= 0; i--) {
			System.out.print(i + " ");
		}
	}

}