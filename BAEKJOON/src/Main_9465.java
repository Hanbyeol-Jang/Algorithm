import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[2][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][n];
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            for (int j = 1; j < n; j++) {
                int max = 0;

                max = Math.max(dp[1][j - 1], dp[2][j - 1]);
                dp[0][j] = sticker[0][j] + max;

                max = Math.max(dp[0][j - 1], dp[2][j - 1]);
                dp[1][j] = sticker[1][j] + max;

                max = Math.max(dp[0][j - 1], dp[1][j - 1]);
                max = Math.max(max, dp[2][j - 1]);

                dp[2][j] = max;
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}
