import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long sum = 0;

		for (int i = N - 1; i >= 0; i--) {
			int cur = arr[i];
			cur = (cur + i - N + 1);

			if (cur > 0) {
				sum += cur;
			} else {
				break;
			}
		}

		System.out.println(sum);
	}
}
