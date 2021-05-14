import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
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
			int temp = Arrays.binarySearch(arrA, list[i]);

			if (temp >= 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

}