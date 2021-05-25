import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2562 {

	public static class Number {
		int num;
		int idx;

		Number(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Number> list = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			list.add(new Number(num, i));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.num < o2.num) {
				return 1;
			} else if (o1.num > o2.num) {
				return -1;
			}

			return 0;
		});

		System.out.println(list.get(0).num);
		System.out.println(list.get(0).idx + 1);

	}
}
