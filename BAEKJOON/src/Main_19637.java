import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19637 {

	public static class Alias {
		String name;
		long score;

		Alias(String name, long score) {
			this.name = name;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Alias> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String s = st.nextToken();
			int temp = Integer.parseInt(st.nextToken());

			list.add(new Alias(s, temp));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int score = Integer.parseInt(st.nextToken());

			int left = 0;
			int right = list.size() - 1;
			int mid = 0;

			while (left <= right) {

				mid = (left + right) / 2;

				if (list.get(mid).score >= score) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			
			sb.append(list.get(left).name + "\n");
		}

		System.out.println(sb);

	}

}
