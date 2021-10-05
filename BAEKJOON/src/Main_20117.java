import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20117 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		int sum = 0;

		for (int i = 0; i < N / 2; i++) {
			int tail = list.get(N - 1 - i);

			sum += (tail * 2);
		}

		if (list.size() % 2 == 1) {
			sum += list.get(N / 2);
		}

		System.out.println(sum);

	}
}
