public class Solution_도둑질 {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};

        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int n = money.length;

        int[] dp = new int[n];
        dp[0] = money[0];
        dp[1] = money[0];

        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

        int answer = Math.max(dp[n - 2], dp2[n - 1]);
        return answer;
    }
}
