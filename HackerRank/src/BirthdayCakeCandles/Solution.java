package BirthdayCakeCandles;

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
	 * Complete the 'birthdayCakeCandles' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY candles as parameter.
	 */

	public static int birthdayCakeCandles(List<Integer> candles) {
		// Write your code here

		int ans = 1;

		Collections.sort(candles, Collections.reverseOrder());

//		for (int i = 0; i < candles.size(); i++) {
//			System.out.print(candles.get(i) + " ");
//		}
//		System.out.println();

		for (int i = 0; i < candles.size()-1; i++) {

			if (candles.get(i).equals(candles.get(i + 1))) {
				ans++;
			} else {
				break;
			}
		}

		System.out.println(ans);
		return ans;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = Result.birthdayCakeCandles(candles);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();

		bufferedReader.close();
//		bufferedWriter.close();
	}
}
