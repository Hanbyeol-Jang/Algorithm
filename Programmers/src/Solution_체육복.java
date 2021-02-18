import java.util.Arrays;

public class Solution_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
//		int[] reserve = { 3 };

//		int n = 3;
//		int[] lost = { 1, 2 };
//		int[] reserve = { 2, 3 };

		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {

		int[] check = new int[n + 1];

		check[0] = 0;
		Arrays.fill(check, 1);

		for (int i = 0; i < lost.length; i++) {
			check[lost[i]] = 0;

			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] < 0) {
					continue;
				}

				if (lost[i] == reserve[j]) {
					check[reserve[j]] = 1;
					reserve[j] = -1;
					lost[i] = -1;
				}
			}
		}

		for (int i = 0; i < lost.length; i++) {
			if (lost[i] < 0) {
				continue;
			}

			int temp1 = lost[i] - 1;
			int temp2 = lost[i] + 1;

			for (int j = 0; j < reserve.length; j++) {
				if (reserve[j] == -1) {
					continue;
				}

				if (temp1 == reserve[j] || temp2 == reserve[j]) {
					check[lost[i]] = 1;

					reserve[j] = -1;
					break;
				}
			}
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (check[i] == 1) {
				System.out.print(i + " ");
				answer++;
			}
		}
		System.out.println();
		return answer;
	}
}
