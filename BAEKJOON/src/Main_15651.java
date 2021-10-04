import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651 {

	public static int N;
	public static int M;

	public static int[] num;
	public static boolean[] visited;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];
		visited = new boolean[N];

		sb = new StringBuilder();

		combi(0, 0);

		System.out.println(sb);
	}

	public static void combi(int start, int count) {
		if (count == M) {
			printArr(num);
			return;
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			num[count] = i + 1;
			combi(i, count + 1);
			visited[i] = false;
		}
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < M; i++) {
			sb.append(arr[i] + " ");
		}
		sb.append("\n");
	}

}
