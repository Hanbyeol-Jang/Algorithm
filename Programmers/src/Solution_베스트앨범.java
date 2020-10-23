import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution_베스트앨범 {

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		System.out.println(solution(genres, plays));
	}

	public static Map<String, Integer> map = new HashMap<>();
	public static Map<String, Integer> select;
	public static LinkedList<String> list;

	public static int[] solution(String[] genres, int[] plays) {

		Map<String, Integer> select = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			select.put(genres[i], plays[i]);

			if (map.containsKey(genres[i])) {
				map.put(genres[i], map.get(genres[i]) + plays[i]);
			} else {
				map.put(genres[i], plays[i]);
			}
		}

		list = new LinkedList<>(map.keySet());

		Collections.sort(list, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));

		LinkedList<Integer> ansList = new LinkedList<>();
		
		for (int i = 0; i < list.size(); i++) {
			Map<Integer, Integer> temp = new HashMap<>();

			for (int j = 0; j < plays.length; j++) {
				if (list.get(i).equals(genres[j])) {
					temp.put(j, plays[j]);
				}
			}

			LinkedList<Integer> tempList = new LinkedList<>(temp.keySet());

			Collections.sort(tempList, (o1, o2) -> temp.get(o2).compareTo(temp.get(o1)));

			tempList.get(0);
			ansList.add(tempList.get(0));

			if (tempList.size() != 1) {
				ansList.add(tempList.get(1));
			}
		}

		int[] answer = new int[ansList.size()];

		for (int i = 0; i < ansList.size(); i++) {
			answer[i] = ansList.get(i);
		}

		return answer;
	}
}
