package D1;

import java.util.Scanner;

public class Solution_2025 {

	static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int sum = 0;

		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}

}
