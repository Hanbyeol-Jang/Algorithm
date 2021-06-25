import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2839_2 {

	public static int[] num;
	public static int N;
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];
		dp[N] = N;

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i <= N / 5; i++) {
			for (int j = 0; j <= N / 3; j++) {
				dp[i * 5] = i * 5;
				dp[j * 3] = j * 3;

				if (dp[N] == dp[i * 5] + dp[j * 3]) {
					answer = Math.min(answer, i + j);
				}
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

}
