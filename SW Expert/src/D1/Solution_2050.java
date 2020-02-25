package D1;

import java.util.Scanner;

public class Solution_2050 {

	static String s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();

		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			System.out.print((int) c[i] - 64 + " ");
		}

	}

}
