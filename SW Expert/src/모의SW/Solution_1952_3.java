package 모의SW;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1952_3 {

	static int TestCase;
	static int[] price;
	static int[] month;
	static int[] cost;

	static int[] monthTemp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			price = new int[4];
			month = new int[13];
			cost = new int[4];

			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}

			int sum = 0;

			for (int i = 1; i <= 12; i++) {
				month[i] = sc.nextInt();
				int temp = month[i] * price[0];

				if (temp >= price[1]) {
					month[i] = price[1];
				} else {
					month[i] = temp;
				}

				sum += month[i];
			}

//			for (int i = 1; i <= 12; i++) {
//				System.out.print(month[i] + " ");
//			}
//			System.out.println();

			cost[0] = sum;
			sum = 0;

			sum = 0;
			int c = 0;

			monthTemp = new int[13];

			for (int i = 1; i <= 12; i++) {
				monthTemp[i] = month[i];
			}

			for (int i = 1; i <= 10; i++) {
				int temp = month[i] + month[i + 1] + month[i + 2];
//				System.out.print(temp + " ");
//				System.out.println(month[i] + " " + month[i + 1] + " " + month[i + 2] + " = " + temp);

				if (temp >= price[2]) {
					if (month[i] != 0) {
						month[i] = price[2];
//						month[i + 1] = 0;
//						month[i + 2] = 0;
						i += 2;
					}
				}
			}

			for (int i = 1; i <= 12; i++) {
				sum += month[i];
			}
			cost[1] = sum;

			for (int i = 12; i >= 3; i--) {
				int temp = month[i] + month[i - 1] + month[i - 2];
//				System.out.println(month[i] + " " + month[i + 1] + " " + month[i + 2] + " = " + temp);

				if (temp >= price[2]) {
					monthTemp[i] = price[2];
					monthTemp[i - 1] = 0;
					monthTemp[i - 2] = 0;
					i -= 2;
				}
			}

//			for (int i = 1; i <= 12; i++) {
//				System.out.print(month[i] + " ");
//			}
//			System.out.println();
//
//			for (int i = 1; i <= 12; i++) {
//				System.out.print(monthTemp[i] + " ");
//			}
//			System.out.println();

			sum = 0;
			for (int i = 1; i <= 12; i++) {
				sum += monthTemp[i];
			}

			cost[2] = sum;
			cost[3] = price[3];

//			for (int i = 0; i < 3; i++) {
//				System.out.print(cost[i] + " ");
//			}
//			System.out.println();

			Arrays.sort(cost);
		
			System.out.println("#" + T + " " + cost[0]);
		}
	}
}
