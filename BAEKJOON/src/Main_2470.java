import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {

	public static class Point {
		int y;
		int x;
		long mix;

		Point(int y, int x, long mix) {
			this.y = y;
			this.x = x;
			this.mix = mix;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		long min = Long.MAX_VALUE;

		long ans1 = 0;
		long ans2 = 0;

		while (true) {
			if (left >= right) {
				break;
			}

			if (min > Math.abs(arr[left] + arr[right])) {
				min = Math.abs(arr[left] + arr[right]);
				ans1 = arr[left];
				ans2 = arr[right];
			}

			if (Math.abs(arr[left] + arr[right - 1]) < Math.abs(arr[left + 1] + arr[right])) {
				right--;
			} else {
				left++;
			}

		}

		System.out.println(ans1 + " " + ans2);

	}
}
