import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long left = 0;
		long right = arr[N - 1];
		long mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			long temp = 0;

			for (int i = 0; i < N; i++) {
				if (mid != 0) {
					temp += (arr[i] / mid);
				} else {
					System.out.println(1);
					return;
				}
			}

			if (temp < K) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(right);

	}
}
