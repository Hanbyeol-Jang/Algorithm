package D3;

import java.util.Scanner;
import java.util.Stack;

public class Solution_8931 {

	static int TestCase;
	static int K;
	static int[] num;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		for (int T = 1; T <= TestCase; T++) {
			sum = 0;
			st.clear();
			K = sc.nextInt();

			num = new int[K];

			for (int i = 0; i < K; i++) {
				num[i] = sc.nextInt();
				st.push(num[i]);

				if (st.peek() == 0) {
					st.pop();
					st.pop();
				}
			}

			while (!st.isEmpty()) {
				sum += st.pop();
			}
			System.out.println("#" + T + " " + sum);

		}

	}

}
