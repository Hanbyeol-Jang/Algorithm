import java.util.Collections;
import java.util.LinkedList;

public class Solution_K번째수 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.println(solution(array, commands));
	}

	public static int[] solution(int[] array, int[][] commands) {

		LinkedList<Integer> list = new LinkedList<>();
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			list.clear();
			int start = commands[i][0] - 1;
			int end = commands[i][1] - 1;
			int idx = commands[i][2];

			for (int j = start; j <= end; j++) {
				list.add(array[j]);
			}

			Collections.sort(list, (o1, o2) -> o1.compareTo(o2));

			answer[i] = list.get(idx - 1);

		}

		return answer;
	}
}
