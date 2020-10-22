import java.util.Arrays;

public class Solution_완주하지못한선수 {

	public static void main(String[] args) {
		// participant 참여자
		// completion 완주
//		String[] participant = { "leo", "kiki", "eden" };
//		String[] completion = { "eden", "kiki" };

		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };

		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
//		for (int i = 0; i < participant.length; i++) {
//			System.out.print(participant[i] + " ");
//		}
//		System.out.println();

		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < participant.length; i++) {
			System.out.print(participant[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < completion.length; i++) {
			System.out.print(completion[i] + " ");
		}
		System.out.println();

		String answer = "not yet";

		for (int i = 0; i < completion.length; i++) {
			if (participant[i].equals(completion[i])) {
				continue;
			} else {
				System.out.println("!!!");
				answer = participant[i];
				break;
			}
		}

		if (answer.equals("not yet")) {
			answer = participant[participant.length - 1];
		}

		return answer;
	}
}
