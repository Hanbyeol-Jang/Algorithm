import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {

	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		num = new int[M];

		perm(N, M, 0, 0);
	}

	public static void perm(int n, int r, int flag, int count) {
		if (count == r) {

			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();

			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) == 0) {
				num[count] = i + 1;
				perm(n, r, flag | 1 << i, count + 1);
			}
		}
	}

}