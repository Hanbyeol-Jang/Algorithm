package ClimbingtheLeaderboard;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'climbingLeaderboard' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY ranked 2. INTEGER_ARRAY player
	 */

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here

		List<Integer> answer = new LinkedList<>();

		List<Integer> list = new ArrayList<>();

		list.add(ranked.get(0));
		int check = list.get(0);

		for (int i = 1; i < ranked.size(); i++) {
			int cur = ranked.get(i);

			if (check == cur) {
				continue;
			}

			list.add(cur);
			check = cur;
		}

//		System.out.println("---------------------");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
//		System.out.println();
//		System.out.println("---------------------");

		for (int i = 0; i < player.size(); i++) {
			int cur = player.get(i);

			int left = 0;
			int right = list.size() - 1;
			int mid = 0;

			while (true) {

				mid = (left + right) / 2;
//				System.out.println(cur + " " + left + " " + right + " " + mid);

				if (cur == list.get(mid)) {
					answer.add(mid + 1);
					break;
				}

				if (left >= right) {
					if (right <= 0) {
						answer.add(1);
						break;
					}

					if (cur < list.get(left)) {
						answer.add(list.size() + 1);
						break;
					}

					answer.add(left + 1);
					break;
				}

				if (cur < list.get(mid)) {
					left = mid + 1;
				} else if (cur > list.get(mid)) {
					right = mid;
				} else {
					mid++;
				}

			}

		}

		return answer;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.climbingLeaderboard(ranked, player);

//		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

		bufferedReader.close();
//		bufferedWriter.close();
	}
}
