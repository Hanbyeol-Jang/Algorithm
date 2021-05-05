import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution_베스트앨범2 {
	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		System.out.println(solution(genres, plays));
	}

	public static class Music {
		String genre;
		int play;
		int idx;

		Music(String genre, int play, int idx) {
			this.genre = genre;
			this.play = play;
			this.idx = idx;
		}
	}

	public static int[] solution(String[] genres, int[] plays) {

		ArrayList<Music> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> countMap = new HashMap<>();
		LinkedList<Integer> ansList = new LinkedList<>();

		for (int i = 0; i < genres.length; i++) {
			list.add(new Music(genres[i], plays[i], i));

			if (map.containsKey(genres[i])) {
				map.replace(genres[i], map.get(genres[i]) + plays[i]);
			} else {
				map.put(genres[i], plays[i]);
				countMap.put(genres[i], 0);
			}
		}

		Collections.sort(list, (o1, o2) -> {
			if (map.get(o1.genre) < map.get(o2.genre)) {
				return 1;
			} else if (map.get(o1.genre) > map.get(o2.genre)) {
				return -1;
			} else {
				if (o1.play < o2.play) {
					return 1;
				} else if (o1.play > o2.play) {
					return -1;
				}

			}

			return 0;
		});

		for (int i = 0; i < list.size(); i++) {
			String genre = list.get(i).genre;

			if (countMap.get(genre) < 2) {
				ansList.add(list.get(i).idx);
				countMap.replace(genre, countMap.get(genre) + 1);
			} else {
				continue;
			}
		}

		int[] answer = new int[ansList.size()];
		for (int i = 0; i < ansList.size(); i++) {
			answer[i] = ansList.get(i);
		}
		return answer;
	}
}
