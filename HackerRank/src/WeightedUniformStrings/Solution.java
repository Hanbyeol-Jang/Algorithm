package WeightedUniformStrings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'weightedUniformStrings' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * following parameters: 1. STRING s 2. INTEGER_ARRAY queries
	 */

	public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
		// Write your code here

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			list.add(cur - '0' - 48);

			if (i + 1 >= s.length()) {
				break;
			}

			char next = s.charAt(i + 1);

			if (cur == next) {
				int cnt = 1;

				while (true) {

					if (i + 1 >= s.length()) {
						break;
					}

					next = s.charAt(i + 1);

					if (cur != next) {
						break;
					}

					cnt++;
					list.add(cnt * (cur - '0' - 48));
					i++;
				}
			}

		}

		Collections.sort(list);

		int max = list.get(list.size() - 1);

		int[] num = new int[max + 1];

		for (int i = 0; i < list.size(); i++) {
			num[list.get(i)] = 1;
		}

		List<String> answer = new ArrayList<>();

		for (int i = 0; i < queries.size(); i++) {
			int cur = queries.get(i);

			if (cur > max) {
				answer.add("No");
				continue;
			}

			if (num[cur] != 1) {
				answer.add("No");
			} else {
				answer.add("Yes");
			}
		}

		return answer;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<String> result = Result.weightedUniformStrings(s, queries);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

		/*
		 * bufferedWriter.write( result.stream() .collect(joining("\n")) + "\n" );
		 */

		bufferedReader.close();
//        bufferedWriter.close();
	}
}
