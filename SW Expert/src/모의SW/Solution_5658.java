package 모의SW;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_5658 {

	static int TestCase;
	static int N, K;
	static StringBuilder sb;
	static char[][] map;
	static int sum;
	static int max;
	static LinkedList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			K = sc.nextInt();
			sb = new StringBuilder(sc.next());

			int len = sb.length();
			int len4 = len / 4;
			map = new char[4][len];
			sum = 0;
			max = Integer.MIN_VALUE;
			list = new LinkedList<>();

			for (int i = 0; i < len; i++) {
				insertNum(len4);

				sb.insert(0, sb.charAt(len - 1));
				sb.deleteCharAt(len);

				calc(len4);
			}

			Collections.sort(list, Collections.reverseOrder());

			System.out.println("#" + T + " " + list.get(K - 1));
		}
	}

	public static void insertNum(int l) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < l; j++) {
				map[i][j] = sb.charAt(i * l + j);
			}
		}
	}

	public static void calc(int l) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < l; j++) {

				int num = map[i][j] - '0';
				if (checked(map[i][j])) {
					num -= 7;
				}

				sum += num * Math.pow(16, l - j - 1);

			}

			if (!list.contains(sum)) {
				list.add(sum);
			}
			sum = 0;
		}
	}

	public static boolean checked(char ch) {
		if (ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F')
			return true;
		else
			return false;
	}

	public static void printMap(char[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}
}
