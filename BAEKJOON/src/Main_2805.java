import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long left = 0;
		long right = arr[N - 1];
		long mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			long sum = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= mid) {
					sum += arr[i] - mid;
				}
			}

			if (sum < M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(right);

	}
}
