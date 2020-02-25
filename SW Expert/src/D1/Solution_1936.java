package D1;

import java.util.Scanner;

public class Solution_1936 {

	static int a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();

		if (a == 1) {
			if (b == 2) {
				System.out.println("B");
			} else
				System.out.println("A");

		} else if (a == 2) {
			if (b == 3) {
				System.out.println("B");
			} else
				System.out.println("A");

		} else {
			if (b == 1) {
				System.out.println("B");
			} else
				System.out.println("A");

		}

	}

}
