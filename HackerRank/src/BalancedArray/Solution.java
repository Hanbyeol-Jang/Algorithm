package BalancedArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import org.omg.Messaging.SyncScopeHelper;

class Result {

	/*
	 * Complete the 'balancedSum' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static int balancedSum(List<Integer> arr) {

		int answer = 0;
		int value = arr.get(arr.size() - 1);
		int sumFirst = 0;
		int sumLast = 0;
		for (int i = 0; i < arr.size(); i++) {
			sumFirst += arr.get(i);
			sumLast += arr.get(arr.size() - 1 - i);

			if (sumFirst == sumLast) {
				System.out.println(sumFirst);
				break;
			}

		}

		return answer;

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

		int result = Result.balancedSum(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

		System.out.println(result);
		bufferedReader.close();
//        bufferedWriter.close();
	}
}
