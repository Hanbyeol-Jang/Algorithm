import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			Map<Character, Integer> map = new HashMap<>();

			for (int j = 0; j < s.length(); j++) {
				char cur = s.charAt(j);

				if (!map.containsKey(cur)) {
					map.put(cur, 1);
				} else {
					map.replace(cur, map.get(cur) + 1);
				}
			}

			int cnt = 1;
			boolean flag = false;

			for (int j = 0; j < s.length() - 1; j++) {
				char cur = s.charAt(j);
				char nex = s.charAt(j + 1);

				if (cur == nex) {
					cnt++;
				} else {
					int check = map.get(cur);

					if (cnt != check) {
						flag = true;
						break;
					}

					cnt = 1;
				}
			}

			if (!flag) {
				answer++;
			}
		}
		System.out.println(answer);

	}
}
