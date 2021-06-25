import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1302 {

	public static class Book {
		String name;
		int cnt;

		Book(String name, int cnt) {
			this.name = name;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		List<Book> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String book = st.nextToken();

			if (map.containsKey(book)) {
				map.replace(book, map.get(book) + 1);
			} else {
				map.put(book, 1);
			}
		}

		for (String s : map.keySet()) {
			list.add(new Book(s, map.get(s)));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.cnt < o2.cnt) {
				return 1;
			} else if (o1.cnt > o2.cnt) {
				return -1;
			} else {
				return o1.name.compareTo(o2.name);
			}
		});

		System.out.println(list.get(0).name);

	}
}
