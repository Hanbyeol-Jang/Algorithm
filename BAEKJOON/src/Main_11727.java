import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        dp[1] = 1;

        if (n > 1) {
            dp[2] = 3;

            for (int i = 3; i <= n; i++) {
                int ex = (int) (Math.pow(2, (i - 1) % 10007) % 10007);
                dp[i] = (dp[i - 2] + ex) % 10007;
            }
        }

        System.out.println(dp[n]);
    }
}
