import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16171 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken();

		st = new StringTokenizer(br.readLine());
		String K = st.nextToken();

		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();

		int answer = 0;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			int temp = c - '0';

			if (temp > 9) {
				sb.append(c);
			}

			if (c == K.charAt(0)) {
				list.add(sb.length() - 1);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int idx = list.get(i);

			if (sb.length() - idx < K.length()) {
				break;
			}

			if (K.equals(sb.toString().substring(idx, idx + K.length()))) {
				answer = 1;
				break;
			}
		}

		System.out.println(answer);

	}
}
