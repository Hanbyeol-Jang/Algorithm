import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];

        dp[0][1] = arr[0];
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], arr[i]);

            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0] + arr[i]);

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}
