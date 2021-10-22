import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14889 {

    public static int N;
    public static int r;
    public static int[][] map;

    public static boolean[] visited;

    public static int scoreA;
    public static int scoreB;

    public static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = N / 2;
        map = new int[N][N];

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        combi(0, 0);

        System.out.println(min);
    }

    public static void combi(int start, int count) {
        if (count == r) {
            compare();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void compare() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        scoreA = 0;
        scoreB = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                a.add(i);
            } else {
                b.add(i);
            }
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                scoreA += map[a.get(i)][a.get(j)];
                scoreA += map[a.get(j)][a.get(i)];

                scoreB += map[b.get(i)][b.get(j)];
                scoreB += map[b.get(j)][b.get(i)];
            }
        }

        int diff = Math.abs(scoreA - scoreB);
        min = Math.min(min, diff);
    }
}
