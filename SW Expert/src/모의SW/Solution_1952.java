package 모의SW;

import java.util.Scanner;

public class Solution_1952 {

	static int TestCase;
	static int[] price;
	static int[] month;
	static int cost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			price = new int[4];
			month = new int[13];
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 1; i <= 12; i++) {
				month[i] = sc.nextInt();
			}

			cost = Integer.MAX_VALUE;
			dfs(1, 0);
			System.out.println("#" + T + " " + cost);
		}
	}

	public static void dfs(int i, int sum) {
		if (i > 12) {
			if (cost > sum) {
				cost = sum;
			}
			return;
		}

		dfs(i + 1, sum + month[i] * price[0]);
		dfs(i + 1, sum + price[1]);

		dfs(i + 3, sum + price[2]);

		dfs(i + 12, sum + price[3]);
	}
}