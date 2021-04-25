import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_보석쇼핑 {

	public static void main(String[] args) {
//		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		// 3, 7
//		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
		// 1, 3
//		String[] gems = { "XYZ", "XYZ", "XYZ" };
		// 1, 1
		String[] gems = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
		// 1, 5
//		String[] gems = { "DIA", "EM", "EM", "RUB", "DIA" };
		// 3, 5
//		String[] gems = { "A", "A", "B" };
		// 2, 3
		System.out.println(solution(gems));
	}

	public static class Point {
		int start;
		int end;
		int cnt;

		Point(int start, int end, int cnt) {
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}
	}

	public static int[] solution(String[] gems) {
		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < gems.length; i++) {
			set.add(gems[i]);
		}

		int start = 0;
		int end = 0;
		int cnt = 1;

		ArrayList<Point> list = new ArrayList<>();

		map.put(gems[start], 1);

		while (true) {

			if (map.size() < set.size()) {
				end++;
				if (end >= gems.length) {
					break;
				}

				if (map.containsKey(gems[end])) {
					map.put(gems[end], map.get(gems[end]) + 1);
				} else {
					map.put(gems[end], 1);
				}

				cnt++;
			} else if (map.size() >= set.size()) {
				list.add(new Point(start, end, cnt));

				if (map.containsKey(gems[start])) {
					int temp = map.get(gems[start]) - 1;

					if (temp == 0) {
						map.remove(gems[start]);
					} else {
						map.put(gems[start], temp);
					}
				}

				start++;
				cnt--;
			}
		}

		Collections.sort(list, (Point o1, Point o2) -> {
			if (o1.cnt > o2.cnt) {
				return 1;
			} else if (o1.cnt < o2.cnt) {
				return -1;
			}
			return 0;
		});

		int[] answer = new int[2];
		answer[0] = list.get(0).start + 1;
		answer[1] = list.get(0).end + 1;
		
		System.out.println(answer[0] + " " + answer[1]);

		return answer;
	}
}
