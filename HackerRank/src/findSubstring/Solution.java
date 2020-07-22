package findSubstring;

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
	 * Complete the 'findSubstring' function below.
	 *
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING s 2. INTEGER k
	 */

	public static String findSubstring(String s, int k) {
		StringBuilder maxVowel = new StringBuilder("Not found!");
		int max = 0;
		int len = s.length();

		for (int j = 0; j + k <= len; j++) {
			StringBuilder sb = new StringBuilder();

			for (int i = j; i < j + k; i++) {
				sb.append(s.charAt(i));
			}
			int cntTemp = countVowel(sb.toString());
			
			if (cntTemp > max) {
				max = cntTemp;
				maxVowel = sb;
			}
		}

		String m = maxVowel.toString();

		return m;
	}

	public static int countVowel(String sbTemp) {
		int len = sbTemp.length();
		int cnt = 0;

		for (int i = 0; i < len; i++) {
			char temp = sbTemp.charAt(i);

			if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
				cnt++;
			}
		}

		return cnt;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		String result = Result.findSubstring(s, k);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();

//		String s = "azerdii";
//		int k = 5;
//
//		String result = Result.findSubstring(s, k);
//		System.out.println(result);
	}
}
