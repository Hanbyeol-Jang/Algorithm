import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {

	public static int N;
	public static int S;
	public static int r;

	public static int[] arr;
	public static int[] num;
	public static boolean[] visited;

	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			r = i;
			num = new int[r];
			visited = new boolean[N];
			combi(0, 0);
		}

		System.out.println(cnt);
	}

	public static void combi(int start, int count) {
		if (count == r) {
			check(num);
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

	public static void check(int[] array) {
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += arr[array[i]];
		}

		if (sum == S) {
			cnt++;
		}
	}
}
