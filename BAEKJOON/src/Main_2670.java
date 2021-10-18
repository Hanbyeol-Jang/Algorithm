import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Double.parseDouble(st.nextToken());
        }

        double max = arr[0];

        for (int i = 1; i < N; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] * arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.printf("%.3f", max);
    }
}
