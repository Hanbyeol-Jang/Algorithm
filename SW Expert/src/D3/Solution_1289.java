package D3;

import java.util.Scanner;

public class Solution_1289 {

	public static int TestCase;
	public static StringBuilder memory;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= 1; T++) {
			memory = new StringBuilder(sc.next());
			int len = memory.length();
			System.out.println(len);

			StringBuilder init = new StringBuilder();
			for (int i = 0; i < len; i++) {
				init.append("0");
			}

			for (int i = 0; i < len; i++) {
				if (memory.charAt(i) == 0) {
					continue;
				} else {
					if (init.charAt(i) == 0) {
						init.delete(i, len);
					}
					for (int j = i; j < len; j++) {
						init.append("1");
					}
				}
				System.out.println("init:" + init);
			}

		}
	}
}
