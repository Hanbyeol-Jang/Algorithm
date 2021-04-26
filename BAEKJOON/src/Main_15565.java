import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_15565 {

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
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			// 1 라이언
			// 2 어피치
		}

		int start = 0;
		int end = 0;
		int cnt = 0;

		ArrayList<Point> list = new ArrayList<>();

		if (num[start] == 1) {
			cnt++;
		}

		while (true) {
//			System.out.println(start + " " + end);
//			System.out.println(cnt);
			if (cnt < K) {
				end++;

				if (end >= N) {
					if (start >= N) {
						break;
					} else {
						end = N - 1;
						if (num[start] == 1) {
							cnt--;
						}

						start++;
						if (start >= N) {
							break;
						}

					}

					continue;
				}

				if (num[end] == 1) {
					cnt++;
				}

			} else if (cnt >= K) {
				list.add(new Point(start, end));
//				System.out.println("!!!!!!!!");

				if (num[start] == 1) {
					cnt--;
				}

				start++;
				if (start >= N) {
					break;
				}

			}
		}

		int answer = 0;
		if (list.size() == 0) {
			answer = -1;
		} else {

			Collections.sort(list, (Point o1, Point o2) -> {
				if (o1.end - o1.start > o2.end - o2.start) {
					return 1;
				} else if (o1.end - o1.start < o2.end - o2.start) {
					return -1;
				}
				return 0;
			});

			answer = list.get(0).end - list.get(0).start + 1;
			// 정렬 후 첫번째
		}

		System.out.println(answer);
	}
}
