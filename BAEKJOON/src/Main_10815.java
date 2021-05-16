import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] arrA = new int[N];

		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] list = new int[M];

		for (int i = 0; i < M; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrA);

		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			int mid = 0;
			int cur = list[i];

			boolean flag = false;

			while (left <= right) {
				mid = (left + right) / 2;

				if (arrA[mid] == cur) {
					flag = true;
					break;
				}

				if (arrA[mid] > cur) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}

			}

			if (flag) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");
			}

		}

	}
}
