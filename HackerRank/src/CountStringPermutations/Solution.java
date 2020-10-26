package CountStringPermutations;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

	/*
	 * Complete the 'countPerms' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts INTEGER n
	 * as parameter.
	 */

	public static char[] c = { 'a', 'e', 'i', 'o', 'u' };
	public static int cnt;
	public static int[] num;
	public static StringBuilder sb = new StringBuilder();
	public static LinkedList<String> list = new LinkedList<>();

	public static int countPerms(int n) {
		// Write your code here

		num = new int[n];
		perm(5, n, 0, 0);

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).contains("30") || list.get(i).contains("31") || list.get(i).contains("33")
					|| list.get(i).contains("22") || list.get(i).contains("11") || list.get(i).contains("13")
					|| list.get(i).contains("14") || list.get(i).contains("00") || list.get(i).contains("02")
					|| list.get(i).contains("03") || list.get(i).contains("04") || list.get(i).contains("41")
					|| list.get(i).contains("42") || list.get(i).contains("43") || list.get(i).contains("44")) {
				cnt--;

			}
		}

		return 0;
	}

	public static void perm(int N, int r, int flag, int count) {
		if (count == r) {
			cnt++;

			for (int i = 0; i < num.length; i++) {
				sb.append(num[i] + "");
			}

			list.add(sb.toString());
			sb = new StringBuilder();

			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				num[count] = i;
				perm(N, r, flag | 1 << i, count + 1);
			}
		}

	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.countPerms(n);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();

		bufferedReader.close();
//		bufferedWriter.close();
	}
}
