package 모의SW;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1952_5 {

	static int TestCase;
	static int[] price;
	static int[] month;
	static int[] cost;

	static LinkedList<Integer> costList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			price = new int[4];
			month = new int[13];
			costList = new LinkedList<>();
			cost = new int[3];

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

			costList.add(sum);
			cost[0] = sum;
			sum = 0;

//			for (int i = 1; i <= 12; i++) {
//				System.out.print(month[i] + " ");
//			}
//			System.out.println();

			sum = 0;

			for (int i = 1; i <= 10; i++) {
				int temp = month[i] + month[i + 1] + month[i + 2];
//				System.out.println(month[i] + " " + month[i + 1] + " " + month[i + 2] + " = " + temp);

				if (temp >= price[2]) {
					month[i] = price[2];
					month[i + 1] = 0;
					month[i + 2] = 0;
					i += 2;
				}
			}

			for (int i = 1; i <= 12; i++) {
				sum += month[i];
			}

			costList.add(sum);
			cost[1] = sum;
			cost[2] = price[3];
			costList.add(price[3]);

//			for (int i = 0; i < costList.size(); i++) {
//				System.out.print(costList.get(i) + " ");
//			}
//			System.out.println();

			Collections.sort(costList);
			Arrays.sort(cost);

			System.out.println("#" + T + " " + costList.get(0));
		}
	}
}