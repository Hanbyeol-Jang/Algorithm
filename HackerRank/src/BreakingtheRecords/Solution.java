package BreakingtheRecords;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'breakingRecords' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY scores as parameter.
	 */

	public static List<Integer> breakingRecords(List<Integer> scores) {
		// Write your code here

		int max = scores.get(0);
		int min = scores.get(0);
		int maxCnt = 0;
		int minCnt = 0;

		for (int i = 1; i < scores.size(); i++) {
			int cur = scores.get(i);

			if (cur > max) {
				max = cur;
				maxCnt++;
			}

			if (cur < min) {
				min = cur;
				minCnt++;
			}
		}

		List<Integer> answer = new ArrayList<>();
		answer.add(maxCnt);
		answer.add(minCnt);

		return answer;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.breakingRecords(scores);

//		bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		System.out.println();

		bufferedReader.close();
//		bufferedWriter.close();
	}
}
