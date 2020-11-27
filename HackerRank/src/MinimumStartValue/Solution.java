package MinimumStartValue;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

	/*
	 * Complete the 'minX' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static int min = 1;

	public static int minX(List<Integer> arr) {
		// Write your code here

		while (!checked(arr)) {
			min++;
		}

		int answer = min;
		return answer;
	}

	public static boolean checked(List<Integer> arr) {

		int sum = min;

		for (int i = 0; i < arr.size(); i++) {

			sum += arr.get(i);
			if (sum < 1) {
				return false;
			}
		}

		return true;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < arrCount; i++) {
			int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
			arr.add(arrItem);
		}

		int result = Result.minX(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

		bufferedReader.close();
//        bufferedWriter.close();
	}
}
