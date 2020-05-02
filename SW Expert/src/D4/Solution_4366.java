package D4;

import java.util.Scanner;

public class Solution_4366 {

	static int TestCase;
	static String num_2;
	static String num_3;

	static int sum_2;
	static int sum_3;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			num_2 = sc.next();
			num_3 = sc.next();

			int len_2 = num_2.length();
			int len_3 = num_3.length();

			StringBuilder temp_2 = new StringBuilder(num_2);
			StringBuilder temp_3 = new StringBuilder(num_3);
			boolean flag = false;
			answer = 0;

			for (int i = 0; i < len_2; i++) {
				if (flag) {
					break;
				}

				if (temp_2.charAt(i) == '0') {
					temp_2.deleteCharAt(i);
					temp_2.insert(i, '1');
				} else {
					temp_2.deleteCharAt(i);
					temp_2.insert(i, '0');
				}
				for (int j = 0; j < len_3; j++) {
					if (flag) {
						break;
					}

					if (temp_3.charAt(j) == '0') {
						temp_3.deleteCharAt(j);
						temp_3.insert(j, '1');
						if (checked(change2(temp_2), change3(temp_3))) {
							answer = change2(temp_2);
							flag = true;
							break;
						}

						temp_3 = new StringBuilder(num_3);
						temp_3.deleteCharAt(j);
						temp_3.insert(j, '2');

						if (checked(change2(temp_2), change3(temp_3))) {
							answer = change2(temp_2);
							flag = true;
							break;
						}

					} else if (temp_3.charAt(j) == '1') {
						temp_3.deleteCharAt(j);
						temp_3.insert(j, '2');
						if (checked(change2(temp_2), change3(temp_3))) {
							answer = change2(temp_2);
							flag = true;
							break;
						}

						temp_3 = new StringBuilder(num_3);
						temp_3.deleteCharAt(j);
						temp_3.insert(j, '0');

						if (checked(change2(temp_2), change3(temp_3))) {
							answer = change2(temp_2);
							flag = true;
							break;
						}
					} else {
						temp_3.deleteCharAt(j);
						temp_3.insert(j, '0');
						if (checked(change2(temp_2), change3(temp_3))) {
							answer = change2(temp_2);
							flag = true;
							break;
						}
						temp_3 = new StringBuilder(num_3);
						temp_3.deleteCharAt(j);
						temp_3.insert(j, '1');

						if (checked(change2(temp_2), change3(temp_3))) {
							answer = change2(temp_2);
							flag = true;
							break;
						}
					}

					temp_3 = new StringBuilder(num_3);
				}

				temp_2 = new StringBuilder(num_2);
			}

			System.out.println("#" + T + " " + answer);

		}
	}

	public static boolean checked(int n1, int n2) {
		if (n1 == n2) {
			return true;
		} else {
			return false;
		}
	}

	public static int change2(StringBuilder s) {
		int len = s.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += (int) ((s.charAt(len - 1 - i) - '0') * Math.pow(2, i));
		}
		return sum;
	}

	public static int change3(StringBuilder s) {
		int len = s.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += (int) ((s.charAt(len - 1 - i) - '0') * Math.pow(3, i));
		}
		return sum;
	}

}
