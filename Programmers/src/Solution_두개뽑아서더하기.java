import java.util.Collections;
import java.util.LinkedList;

public class Solution_두개뽑아서더하기 {

	public static void main(String[] args) {
		int numbers[] = { 5, 0, 2, 7 };
		System.out.println(solution(numbers));
	}

	public static int[] solution(int[] numbers) {

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {

				int sum = 0;
				sum = numbers[i] + numbers[j];
				while (!list.contains(sum)) {
					list.add(sum);
				}
			}
		}

		Collections.sort(list);

		int[] answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}