import java.util.Arrays;

public class Solution_정수삼각형 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {

        int n = triangle.length;

        for (int i = 1; i < n; i++) {
            int len = triangle[i].length;

            triangle[i][0] += triangle[i - 1][0];
            triangle[i][len - 1] += triangle[i - 1][len - 2];

            for (int j = 1; j < len - 1; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        Arrays.sort(triangle[n - 1]);

        int answer = triangle[n - 1][n - 1];
        return answer;
    }
}
