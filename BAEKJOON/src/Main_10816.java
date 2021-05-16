import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816 {

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

		Arrays.sort(arrA);

		int[] list = new int[M];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			list[i] = Integer.parseInt(st.nextToken());

			int cur = list[i];

			sb.append(findUpper(arrA, cur, N - 1) - findLower(arrA, cur, N - 1));
			sb.append(" ");
		}

		System.out.println(sb);
	}

	public static int findUpper(int[] arr, int value, int end) {
		int left = 0;
		int right = end;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (arr[mid] > value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	public static int findLower(int[] arr, int value, int end) {
		int left = 0;
		int right = end;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (arr[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}
