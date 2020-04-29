package D4;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_4050 {

	static int TestCase;
	static int N;
	static int[] arr;
	static int[] num;
	static boolean[] selected;
	static int cnt;

	static LinkedList<Integer> list;
	static LinkedList<Integer> sumList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			arr = new int[N];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			num = new int[3];

			sumList = new LinkedList<>();

			combi(N, 3, 0, 0);

			Collections.sort(sumList);

			System.out.println("#" + T + " " + sumList.get(0));
		}
	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			list = new LinkedList<>();

			for (int i = 0; i < selected.length; i++) {
				if (selected[i]) {
					list.add(arr[i]);
				}
			}
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i) + " ");
//			}

			Collections.sort(list);
			list.remove(0);
			int sum = 0;
			sum += list.get(0);
			sum += list.get(1);

//			System.out.print(" = " + sum);
//			System.out.print(" ||  ");
			for (int i = 0; i < selected.length; i++) {
				if (!selected[i]) {
					sum += arr[i];
//					System.out.print(arr[i] + " ");
				}
			}

//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i) + " ");
//			}
//
			sumList.add(sum);
//			System.out.println(sum);

			return;
		}

		for (int i = start; i < n; i++) {
			if (!selected[i]) {
				selected[i] = true;
				combi(n, r, i + 1, count + 1);
				selected[i] = false;
			}
		}

	}

}
