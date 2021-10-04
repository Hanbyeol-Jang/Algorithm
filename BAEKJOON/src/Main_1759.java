import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {

	public static int L;
	public static int C;
	public static char[] c;
	public static int[] num;

	public static boolean[] visited;

	public static StringBuilder answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		c = new char[C];
		num = new int[L];
		visited = new boolean[C];

		for (int i = 0; i < C; i++) {
			String s = st.nextToken();
			c[i] = s.charAt(0);
		}

		Arrays.sort(c);

		answer = new StringBuilder();

		combi(0, 0);

		System.out.println(answer);
	}

	public static void combi(int start, int count) {
		if (count == L) {
			checkArr(num);
			return;
		}

		for (int i = start; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				num[count] = i;
				combi(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	public static void checkArr(int[] arr) {
		int con = 0;
		int vow = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < L; i++) {
			char cur = c[arr[i]];

			if (vow >= 1 && con >= 2) {

			} else {
				if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
					vow++;
				} else {
					con++;
				}
			}

			sb.append(cur + "");
		}

		if (vow >= 1 && con >= 2) {
			answer.append(sb + "\n");
		}
	}
}
