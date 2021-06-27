import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			if (s.equals("end")) {
				break;
			}

			boolean flag = false;

			if (!minCheck(s)) {
				flag = true;
			}

			int prev = 0;
			int cnt = 1;

			for (int i = 0; i < s.length(); i++) {
				char cur = s.charAt(i);

				if (curCheck(cur)) {
					if (prev == 1) {
						cnt++;
						if (cnt >= 3) {
							flag = true;
							break;
						}
					} else {
						cnt = 1;
					}
					prev = 1;
				} else {
					if (prev == -1) {
						cnt++;
						if (cnt >= 3) {
							flag = true;
							break;
						}
					} else {
						cnt = 1;
					}
					prev = -1;
				}
			}

			for (int i = 0; i < s.length() - 1; i++) {
				char cur = s.charAt(i);
				char nex = s.charAt(i + 1);

				if (cur == nex) {
					if (cur != 'e' && cur != 'o') {
						flag = true;
						break;
					}
				}
			}

			if (!flag) {
				System.out.println("<" + s + "> is acceptable.");
			} else {
				System.out.println("<" + s + "> is not acceptable.");
			}

		}

	}

	public static boolean curCheck(Character c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean minCheck(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				return true;
			}
		}

		return false;
	}
}
