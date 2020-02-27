package 모의SW;

import java.util.Scanner;

public class Solution_1952 {

	static int TestCase;
	static int[] price;
	static int[] month;
	static int day;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			price = new int[4];
			month = new int[13];
			day = 0;

			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 1; i < 13; i++) {
				month[i] = sc.nextInt();
				day += month[i];
			}
			System.out.println(day);

		}
	}
}
