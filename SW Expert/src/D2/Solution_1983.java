package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1983 {

	static int TestCase;
	static int N, K;
	static int[][] student;
	static double[] score;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		for (int T = 1; T <= TestCase; T++) {
			N = sc.nextInt();
			K = sc.nextInt();

			student = new int[N][3];
			score = new double[N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					student[i][j] = sc.nextInt();

					switch (j) {
					case 0:
						score[i] += student[i][j] * 0.35;
						break;
					case 1:
						score[i] += student[i][j] * 0.45;
						break;
					case 2:
						score[i] += student[i][j] * 0.2;
						break;
					}
				}

			}

			double temp = score[K - 1];

			Arrays.sort(score);

			double rank = 0.0;
			for (int i = 0; i < N; i++) {
				if (score[i] == temp) {
					rank = i;
					break;
				}
			}

			rank = N - rank;
			rank = rank / N;
			String grade = "";

			if (rank >= 0 && rank <= 0.1) {
				grade = "A+";
			} else if (rank > 0.1 && rank <= 0.2) {
				grade = "A0";
			} else if (rank > 0.2 && rank <= 0.3) {
				grade = "A-";
			} else if (rank > 0.3 && rank <= 0.4) {
				grade = "B+";
			} else if (rank > 0.4 && rank <= 0.5) {
				grade = "B0";
			} else if (rank > 0.5 && rank <= 0.6) {
				grade = "B-";
			} else if (rank > 0.6 && rank <= 0.7) {
				grade = "C+";
			} else if (rank > 0.7 && rank <= 0.8) {
				grade = "C0";
			} else if (rank > 0.8 && rank <= 0.9) {
				grade = "C-";
			} else {
				grade = "D0";
			}
			System.out.println("#" + T + " " + grade);

		}
	}

}
