package primeornot;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

	/*
	 * Complete the 'isPrime' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * LONG_INTEGER n as parameter.
	 */

	public static int isPrime(long n) {
		// Write your code here

		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				list.add(i);
				cnt++;
			}
		}

		if (cnt > 1) {
			return list.get(1);
		} else {
			return 1;
		}
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		long n = Long.parseLong(bufferedReader.readLine().trim());

		int result = Result.isPrime(n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

		bufferedReader.close();
//        bufferedWriter.close();
	}
}
