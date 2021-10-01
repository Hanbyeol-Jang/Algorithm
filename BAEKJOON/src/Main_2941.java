import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();

		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == 'c') {
				if (i < s.length() - 1) {
					char next = s.charAt(i + 1);
					if (next == '=' || next == '-') {
						i++;
					}
				}
			} else if (c == 'd') {
				if (i < s.length() - 1) {
					char next = s.charAt(i + 1);

					if (next == '-') {
						i++;
					} else if (next == 'z' && i < s.length() - 2) {
						if (s.charAt(i + 2) == '=') {
							i += 2;
						}
					}
				}
			} else if (c == 'l' || c == 'n') {
				if (i < s.length() - 1) {
					char next = s.charAt(i + 1);

					if (next == 'j') {
						i++;
					}
				}
			} else if (c == 's' || c == 'z') {
				if (i < s.length() - 1) {
					char next = s.charAt(i + 1);

					if (next == '=') {
						i++;
					}
				}
			}

			cnt++;
		}

		System.out.println(cnt);
	}

}
