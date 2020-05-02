package D2;

import java.util.Scanner;

public class Solution_1940 {

	static int TestCase;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			int dis = 0;
			int vel = 0;
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int sec = sc.nextInt();

				if (sec == 1) {
					int temp = sc.nextInt();
					vel += temp;
				} else if (sec == 2) {
					int temp = sc.nextInt();

					if (temp > vel) {
						vel = 0;
						continue;
					}
					
					vel -= temp;
				}
				
				dis += vel;
			}
			System.out.println("#" + T + " " + dis);
		}

	}
}
