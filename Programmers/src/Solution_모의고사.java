import java.util.LinkedList;

public class Solution_모의고사 {

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
//		int[] answers = { 1, 3, 2, 4, 2 };

		System.out.println(solution(answers));
	}

	public static int[] solution(int[] answers) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;

		for (int i = 0; i < answers.length; i++) {
			int temp = i;

			if (i >= a.length) {
				temp %= a.length;
			}

			if (answers[i] == a[temp]) {
				cnt1++;
			}

			temp = i;

			if (i >= b.length) {
				temp %= b.length;
			}

			if (answers[i] == b[temp]) {
				cnt2++;
			}

			temp = i;

			if (i >= c.length) {
				temp %= c.length;
			}

			if (answers[i] == c[temp]) {
				cnt3++;
			}
		}

		System.out.println(cnt1 + " " + cnt2 + " " + cnt3);

		int max = Integer.MIN_VALUE;
		max = Math.max(cnt3, Math.max(cnt1, cnt2));

		LinkedList<Integer> list = new LinkedList<>();

		if (max == cnt1) {
			list.add(1);
		}

		if (max == cnt2) {
			list.add(2);
		}

		if (max == cnt3) {
			list.add(3);
		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
