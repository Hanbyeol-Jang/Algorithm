package LastandSecondLast;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

	/*
	 * Complete the 'lastLetters' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING word
	 * as parameter.
	 */

	public static String lastLetters(String word) {
		// Write your code here

		String last = word.charAt(word.length() - 1) + "";
		String secd = word.charAt(word.length() - 2) + "";

		String answer = last + " " + secd;
		return answer;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String word = bufferedReader.readLine();

		String result = Result.lastLetters(word);

//		bufferedWriter.write(result);
//		bufferedWriter.newLine();

		bufferedReader.close();
//		bufferedWriter.close();
	}
}
