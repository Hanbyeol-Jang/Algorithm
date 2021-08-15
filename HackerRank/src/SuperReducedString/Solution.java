package SuperReducedString;

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
	 * Complete the 'superReducedString' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String superReducedString(String s) {
		// Write your code here

		for (int i = 0; i < s.length() - 1; i++) {
			char cur = s.charAt(i);
			char next = s.charAt(i + 1);

			if (cur == next) {
				String head = s.substring(0, i);
				String tail = s.substring(i + 2, s.length());
				s = head + tail;
				i = -1;
			}
		}

		if (s.equals("")) {
			s = "Empty String";
		}

		return s;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.superReducedString(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
		System.out.println(result);
		bufferedReader.close();
//        bufferedWriter.close();
	}
}
