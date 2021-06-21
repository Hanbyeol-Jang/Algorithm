import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {

	public static int[] num;
	public static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new int[N];
		num = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);

		perm(N, M, 0, 0);

	}

	public static void perm(int n, int r, int flag, int count) {
		if (count == r) {

			for (int i = 0; i < num.length; i++) {
				System.out.print(list[num[i]] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) == 0) {
				num[count] = i;
				perm(n, r, flag | 1 << i, count + 1);
			}
		}
	}
}
