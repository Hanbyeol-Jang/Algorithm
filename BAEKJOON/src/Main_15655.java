import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655 {

	public static int N;
	public static int M;

	public static int[] num;
	public static boolean[] visited;
	public static int[] arr;

	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		sb = new StringBuilder();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		num = new int[M];
		visited = new boolean[N];

		combi(0, 0);

		System.out.println(sb);
	}

	public static void combi(int start, int count) {
		if (count == M) {

			for (int i = 0; i < M; i++) {
				sb.append(arr[num[i]] + " ");
			}
			sb.append("\n");

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
}
