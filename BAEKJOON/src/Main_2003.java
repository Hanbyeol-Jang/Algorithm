import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = num[start];
		int cnt = 0;

		while (true) {

			if (sum == M) {
				cnt++;
			}

			if (sum < M) {
				end++;

				if (end >= N) {
					break;
				}

				sum += num[end];

			} else if (sum >= M) {
				sum -= num[start];
				start++;
			}

		}

		System.out.println(cnt);
	}
}
