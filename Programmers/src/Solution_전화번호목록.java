import java.util.Collections;
import java.util.LinkedList;

public class Solution_전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book = { "97674223", "1195524421", "119" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {

		LinkedList<String> list = new LinkedList<>();

		for (int i = 0; i < phone_book.length; i++) {
			list.add(phone_book[i]);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size() - 1; i++) {

			if (list.get(i + 1).contains(list.get(i))) {
				return false;
			}
		}

		boolean answer = true;
		return answer;
	}
}
