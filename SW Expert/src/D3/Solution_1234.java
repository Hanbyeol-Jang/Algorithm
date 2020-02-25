package D3;

import java.util.Scanner;

public class Solution_1234 {

	static int N;
	static String s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T <= 10; T++) {
			N = sc.nextInt();
			s = sc.next();
			char[] c = s.toCharArray();
			StringBuilder sb = new StringBuilder(s);
			int cnt = 1;

			while (true) {
				if (cnt == 0) {
					break;
				}

				cnt = 0;
				for (int i = 0; i < N; i++) {
					if (i + 1 < N & i >= 0) {
						if (sb.charAt(i) != sb.charAt(i + 1)) {
							continue;
						} else {
							sb.delete(i, i + 2);
							i -= 2;
							N -= 2;
							cnt++;
							continue;
						}
					}
				}
			}

			System.out.println("#" + T + " " + sb);

		}

	}

}
