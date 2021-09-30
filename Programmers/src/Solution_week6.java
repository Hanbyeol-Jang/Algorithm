import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_week6 {

	public static class Player {
		double rate;
		int wins;
		int weight;
		int num;

		Player(double rate, int wins, int weight, int num) {
			this.rate = rate;
			this.wins = wins;
			this.weight = weight;
			this.num = num;
		}
	}

	public static int[] solution(int[] weights, String[] head2head) {

		List<Player> list = new ArrayList<>();

		for (int i = 0; i < head2head.length; i++) {
			String s = head2head[i];

			int total = 0;
			int cnt = 0;
			int wins = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'N') {
					continue;
				}

				total++;

				if (s.charAt(j) == 'W') {
					cnt++;

					if (weights[j] > weights[i]) {
						wins++;
					}
				}
			}

			list.add(new Player((double) cnt / total, wins, weights[i], i + 1));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.rate < o2.rate) {
				return 1;
			} else if (o1.rate > o2.rate) {
				return -1;
			} else {
				if (o1.wins < o2.wins) {
					return 1;
				} else if (o1.wins > o2.wins) {
					return -1;
				} else {
					if (o1.weight < o2.weight) {
						return 1;
					} else if (o1.weight > o2.weight) {
						return -1;
					} else {
						if (o1.num > o2.num) {
							return 1;
						} else if (o1.num < o2.num) {
							return -1;
						}
					}
				}
			}
			return 0;
		});

		int[] answer = new int[weights.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i).num;
		}

		return answer;
	}
}