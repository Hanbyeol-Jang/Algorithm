import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution_가장큰수 {

	public static void main(String[] args) {
//		int[] numbers = { 6, 10, 2 };
		int[] numbers = { 3, 30, 34, 5, 9 };
//		int[] numbers = { 0, 0, 0, 0 };

		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {

		LinkedList<String> list = new LinkedList<>();

		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i] + "");
		}

		Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "");
//			System.out.print(list.get(i) + " ");
		}
//		System.out.println();

		if (sb.toString().charAt(0) == '0') {
			return "0";
		} else {
			String answer = sb.toString();
			return answer;
		}

	}

}
