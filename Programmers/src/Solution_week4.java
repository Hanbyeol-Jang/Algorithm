import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_week4 {

	public static class Jobs {
		String job;
		int score;

		Jobs(String job, int score) {
			this.job = job;
			this.score = score;
		}
	}

	public static String solution(String[] table, String[] languages, int[] preference) {

		int len = table.length;

		List<Jobs> list = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			String[] cur = table[i].split(" ");
			String job = cur[0];
			int score = 0;

			for (int j = 1; j < cur.length; j++) {
				String lang = cur[j];

				for (int k = 0; k < languages.length; k++) {
					if (lang.equals(languages[k])) {
						score += (cur.length - j) * preference[k];
					}
				}
			}

			list.add(new Jobs(job, score));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.score < o2.score) {
				return 1;
			} else if (o1.score > o2.score) {
				return -1;
			} else if (o1.score == o2.score) {
				return o1.job.compareTo(o2.job);
			}

			return 0;
		});

		String answer = list.get(0).job;
		return answer;
	}
}