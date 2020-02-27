package 모의SW;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1952 {

	static int TestCase;
	static int[] price;
	static int[] month;
	static int day;
	static int min;

	static boolean[] isc;

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
			min = Integer.MAX_VALUE;
			day = 0;

			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 1; i < 13; i++) {
				month[i] = sc.nextInt();
				if (month[i] != 0) {
					day += month[i];
					monthList.add(i);
				}
			}

//			for (int i = 0; i < monthList.size(); i++) {
//				System.out.print(monthList.get(i) + " ");
//			}
//			System.out.println();

			isc = new boolean[monthList.size()];

			for (int i = 0; i <= monthList.size(); i++) {
				combi(monthList.size(), i, 0, 0);
			}

			costList.add(price[3]);

//			for (int i = 0; i < costList.size(); i++) {
//				System.out.print(costList.get(i) + " ");
//			}
//			System.out.println();

			Collections.sort(costList);

			System.out.println("#" + T + " " + costList.get(0));
		}
	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			int sum = 0;

			for (int i = 0; i < isc.length; i++) {
				if (isc[i]) {
					System.out.print(monthList.get(i) + " ");
					sum += month[monthList.get(i)] * price[0];
				}
			}
			System.out.print(" ||  ");
			for (int i = 0; i < isc.length; i++) {
				if (!isc[i]) {
					System.out.print(monthList.get(i) + " ");
					sum += price[1];
				}
			}
			System.out.println(" ||  " + sum);
			costList.add(sum);
			return;
		}

		for (int i = start; i < n; i++) {
			if (!isc[i]) {
				isc[i] = true;
				combi(n, r, i + 1, count + 1);
				isc[i] = false;
			}
		}

	}

}
