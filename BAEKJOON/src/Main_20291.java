import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20291 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			String[] splits = s.split("\\.");
			String temp = splits[1];

			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				map.replace(temp, map.get(temp) + 1);
			}
		}

		List<String> list = new ArrayList<>(map.keySet());

		Collections.sort(list, (o1, o2) -> {
			return o1.compareTo(o2);
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " " + map.get(list.get(i)));
		}

	}
}