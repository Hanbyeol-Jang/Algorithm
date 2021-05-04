import java.util.HashMap;
import java.util.Map;

public class Solution_완주하지못한선수2 {

	public static void main(String[] args) {
//		String[] participant = { "leo", "kiki", "eden" };
//		String[] completion = { "eden", "kiki" };
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
//		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };

		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < participant.length; i++) {
			String s = participant[i];

			if (map.containsKey(s)) {
				map.replace(s, map.get(s) + 1);
			} else {
				map.put(participant[i], 1);
			}
		}

		for (int i = 0; i < completion.length; i++) {
			String s = completion[i];

			if (map.containsKey(s)) {

				int cnt = map.get(s);
				if (cnt == 1) {
					map.remove(s);
				} else {
					map.replace(s, map.get(s) - 1);
				}

			}
		}

		for (String s : map.keySet()) {
			answer = s;
		}

		return answer;
	}
}
