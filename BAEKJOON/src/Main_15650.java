import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {

	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		num = new int[M];

		combi(N, M, 0, 0);

	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {

			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();

			return;
		}

		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi(n, r, i + 1, count + 1);
		}

	}
}
