import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1806 {

	public static class Point {
		int start;
		int end;

		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;

		sum = num[start];

		ArrayList<Point> list = new ArrayList<>();

		while (true) {
			if (sum < S) {
				end++;

				if (end >= N) {
					end = N - 1;

					if (sum + num[start] >= S) {
						sum -= num[start];
					}

					start++;
					if (start >= N) {
						break;
					}

					continue;
				}

				sum += num[end];
			} else if (sum >= S) {
				list.add(new Point(start, end));
				sum -= num[start];

				start++;
				if (start >= N) {
					break;
				}

			}
		}

		Collections.sort(list, (Point o1, Point o2) -> {
			if (o1.end - o1.start > o2.end - o2.start) {
				return 1;
			} else if (o1.end - o1.start < o2.end - o2.start) {
				return -1;
			}

			return 0;
		});

		int answer = 0;

		if (!list.isEmpty()) {
			answer = list.get(0).end - list.get(0).start + 1;
		}
		System.out.println(answer);

	}

}
