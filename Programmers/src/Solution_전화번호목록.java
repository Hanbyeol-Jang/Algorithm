import java.util.ArrayList;
import java.util.Collections;

public class Solution_전화번호목록 {

	public static void main(String[] args) {
//		String[] phone_book = { "119", "97674223", "1195524421" };
//		String[] phone_book = { "123", "456", "789" };
//		String[] phone_book = { "12", "123", "1235", "567", "88" };
		String[] phone_book = { "123123010", "010", "10" };

		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < phone_book.length; i++) {
			list.add(phone_book[i]);
		}

		Collections.sort(list, (o1, o2) -> {
			return o1.compareTo(o2);
		});

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i + 1).indexOf(list.get(i)) == 0) {
				answer = false;
				break;
			}
		}

		return answer;
	}
}
