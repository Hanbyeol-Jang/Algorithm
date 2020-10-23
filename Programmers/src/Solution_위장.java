import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution_위장 {

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		System.out.println(solution(clothes));
	}

	public static int[] checked;
	public static String[][] temp;
	public static LinkedList<String> list = new LinkedList<>();
	public static Map<String, String> map = new HashMap<>();
	public static int cnt;

	public static int solution(String[][] clothes) {
		temp = clothes;

		int n = clothes.length;
		for (int i = 0; i < n; i++) {
			map.put(clothes[i][0], clothes[i][1]);
		}

		cnt += n;

		boolean flag = false;

		for (int i = 0; i < n; i++) {
			String value = map.get(temp[i][0]);
			if (list.contains(value)) {
				flag = true;
				break;
			} else {
				list.add(value);
			}
		}

		if (!flag) {
			cnt++;
		}

		for (int i = 2; i < n; i++) {
			checked = new int[i];
			combi(n, i, 0, 0);
		}

		int answer = cnt;
		return answer;
	}

	public static void combi(int n, int r, int start, int count) {
		for (int i = 0; i < list.size(); i++) {
			String value = map.get(list.get(i));

//			printArr(checked);
//			System.out.println(value);

			if (list.contains(value)) {
				list.clear();
				return;
			}
		}

		if (count == r) {
			list.clear();

			boolean flag = false;
			for (int i = 0; i < r; i++) {
				String value = map.get(temp[checked[i]][0]);

				if (list.contains(value)) {
					flag = true;
					continue;
				} else {
					list.add(value);
				}
			}

			if (!flag) {
				cnt++;
			}

			return;
		}

		for (int i = start; i < n; i++) {
			checked[count] = i;
			combi(n, r, i + 1, count + 1);
		}
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
