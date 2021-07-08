import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1463 {

	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 1; i <= N; i++) {
			if (i + 1 <= N) {
				if (dp[i + 1] != 0) {
					dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
				} else {
					dp[i + 1] = dp[i] + 1;
				}
			}

			if (i * 2 <= N) {
				if (dp[i * 2] != 0) {
					dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
				} else {
					dp[i * 2] = dp[i] + 1;
				}
			}

			if (i * 3 <= N) {
				if (dp[i * 3] != 0) {
					dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
				} else {
					dp[i * 3] = dp[i] + 1;
				}
			}
		}

		System.out.println(dp[N]);
	}
}