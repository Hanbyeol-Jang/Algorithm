import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		long answer = 0;

		long left = 0;
		long right = arr[N - 1];
		long mid = 0;
		long sum = 0;

		while (left <= right) {

			sum = 0;
			mid = (left + right) / 2;

			for (int i = 0; i < N; i++) {
				if (arr[i] < mid) {
					sum += arr[i];
				} else {
					sum += mid;
				}
			}

			if (sum > M) {
				right = mid - 1;
			} else {
				left = mid + 1;
				answer = Math.max(answer, mid);
			}
		}

		System.out.println(answer);

	}
}
