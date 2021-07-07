import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			if (n == 1 || n == 2) {
				System.out.println(n);
			} else {
				int[] dp = new int[n + 1];

				dp[0] = 0;
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;

				for (int i = 4; i <= n; i++) {
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				}

				System.out.println(dp[n]);
			}

		}
	}
}