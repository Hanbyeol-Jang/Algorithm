import java.util.Arrays;

public class Solution_등굣길 {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}, {3, 1}};

        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[n + 1][m + 1];

        Arrays.fill(map[1], 1);

        for (int i = 1; i <= n; i++) {
            map[i][1] = 1;
        }

        int len = puddles.length;

        for (int i = 0; i < len; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;

            if(puddles[i][1] == 1){
                for (int j = puddles[i][0]; j <= m; j++) {
                    map[1][j] = -1;
                }
            }

            if(puddles[i][0] == 1){
                for (int j = puddles[i][1]; j <= n; j++) {
                    map[j][1] = -1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        int answer = 0;

        if (n >= 2 && m >= 2) {
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    if (map[i][j] >= 0) {
                        int up = 0;
                        int left = 0;

                        if (map[i - 1][j] > 0) {
                            up = map[i - 1][j];
                        }

                        if (map[i][j - 1] > 0) {
                            left = map[i][j - 1];
                        }

                        map[i][j] = (up + left) % 1000000007;
                    }
                }
            }

            answer = map[n][m];
        } else if ((n >= 2 && m == 1) || (n == 1 && m >= 2)) {
            if (len > 0) {
                answer = 0;
            } else {
                answer = 1;
            }
        }

        return answer;
    }
}
