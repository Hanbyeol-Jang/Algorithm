import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1535 {

    public static int N;
    public static int r;

    public static int[] life;
    public static int[] joy;

    public static int[] num;
    public static boolean[] visited;

    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        life = new int[N];
        joy = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            life[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;

        for (int i = 1; i <= N; i++) {
            r = i;
            num = new int[r];
            visited = new boolean[N];
            combi(0, 0);
        }

        System.out.println(answer);
    }

    public static void combi(int start, int count) {
        if (count == r) {

            if (!checkLife(num)) {
                return;
            }

            answer = Math.max(answer, sumJoy(num));
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[count] = i;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean checkLife(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += life[arr[i]];
        }

        if (sum >= 100) {
            return false;
        }

        return true;
    }

    public static int sumJoy(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += joy[arr[i]];
        }

        return sum;
    }
}
