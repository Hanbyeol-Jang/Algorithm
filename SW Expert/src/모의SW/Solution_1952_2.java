package 모의SW;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1952_2 {

	static int TestCase;
	static int[] price;
	static int[] month;
	static int day;

	static LinkedList<Integer> monthList;
	static LinkedList<Integer> costList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			price = new int[4];
			month = new int[13];
			monthList = new LinkedList<>();
			costList = new LinkedList<>();
			day = 0;

			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 1; i <= 12; i++) {
				month[i] = sc.nextInt();
				if (month[i] != 0) {
					day += month[i];
					monthList.add(i);
				}
			}

			int sum = 0;

			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < monthList.size(); i++) {
				int temp = month[monthList.get(i)] * price[0];
				if (temp >= price[1]) {
					sum += price[1];
					list.add(price[1]);
				} else {
					sum += temp;
					list.add(temp);
				}
			}

			costList.add(sum);

			sum = 0;

			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

			int c = 0;
			for (int i = 1; i <= 10; i++) {
				if (month[i] == 0)
					continue;

				if (month[i + 1] != 0 && month[i + 2] != 0) {
					if (price[1] * 3 >= price[2]) {
						sum += price[2];
						i += 2;
					} else {
						sum += list.get(c);
						c++;
						System.out.println(c);
					}
				} else {
					sum += list.get(c);
					c++;
					System.out.println(c);
				}
			}

			costList.add(sum);

			costList.add(price[3]);

			for (int i = 0; i < costList.size(); i++) {
				System.out.print(costList.get(i) + " ");
			}
			System.out.println();

			Collections.sort(costList);

			System.out.println("#" + T + " " + costList.get(0));
		}
	}

}
