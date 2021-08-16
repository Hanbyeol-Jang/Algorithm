package Encryption;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import javax.annotation.processing.AbstractProcessor;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'encryption' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String encryption(String s) {
		// Write your code here

		double temp = Math.sqrt(s.length());
		int f = (int) Math.floor(temp);
		int c = (int) Math.ceil(temp);

		if (f * c < s.length()) {
			f++;
		}

		char[][] map = new char[f][c];

		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {

				int idx = i * c + j;

				if (idx >= s.length()) {
					break;
				}

				map[i][j] = s.charAt(idx);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < f; j++) {
				char cur = map[j][i];

				if (cur == '\u0000') {
					continue;
				}

				sb.append(map[j][i]);
			}
			sb.append(" ");
		}

		return sb.toString();
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.encryption(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

		System.out.println(result);
		bufferedReader.close();
//        bufferedWriter.close();
	}
}
