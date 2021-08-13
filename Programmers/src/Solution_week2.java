import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_week2 {

	public static void main(String[] args) {

//		int[][] scores = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
//				{ 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };
		// "FBABD"

//		int[][] scores = { { 50, 90 }, { 50, 87 } };
		// "DA"

		int[][] score = { { 70, 49, 90 }, { 68, 50, 38 }, { 73, 31, 100 } };
		// "CFD"

		System.out.println(solution(score));

	}

	public static class Point {
		int idx;
		int score;
		int count;

		Point(int idx, int score, int count) {
			this.idx = idx;
			this.score = score;
			this.count = count;
		}

	}

	public static String solution(int[][] scores) {

		List<Point> list = new ArrayList<>();
		Map<Integer, Point> map = new HashMap<>();

		int len = scores.length;
		double[] num = new double[len];

		for (int j = 0; j < len; j++) {
			for (int i = 0; i < len; i++) {
				int curScore = scores[i][j];

				list.add(new Point(i, curScore, 0));

				if (map.containsKey(curScore)) {
					int curIdx = map.get(curScore).idx;
					int curCnt = map.get(curScore).count;

					map.replace(curScore, new Point(curIdx, curScore, curCnt + 1));
				} else {
					map.put(curScore, new Point(i, curScore, 1));
				}
			}

			Collections.sort(list, (o1, o2) -> {
				if (o1.score < o2.score) {
					return 1;
				} else if (o1.score > o2.score) {
					return -1;
				} else {
					return 0;
				}
			});

			if (j == list.get(0).idx) {
				if (map.get(list.get(0).score).count == 1) {
					list.remove(0);
				}
			}

			if (j == list.get(list.size() - 1).idx) {
				if (map.get(list.get(list.size() - 1).score).count == 1) {
					list.remove(list.size() - 1);
				}
			}

			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i).score;
			}

			num[j] = (double) sum / list.size();

			list.clear();
			map.clear();
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			sb.append(check(num[i]));
		}

		String answer = sb.toString();
		return answer;
	}

	public static String check(double point) {
		String s = "";

		if (point >= 90) {

			s = "A";
		} else if (point >= 80 && point < 90) {
			s = "B";
		} else if (point >= 70 && point < 80) {
			s = "C";
		} else if (point >= 50 && point < 70) {
			s = "D";
		} else {
			s = "F";
		}

		return s;
	}
}
