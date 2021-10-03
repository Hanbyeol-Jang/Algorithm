import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1966 {

	public static class Node {
		int idx;
		int weight;

		Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			List<Node> list = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				list.add(new Node(i, Integer.parseInt(st.nextToken())));
			}

			int cnt = 0;
			while (true) {
				if (list.isEmpty()) {
					break;
				}

				Node cur = list.get(0);

				boolean flag = false;
				for (int i = 1; i < list.size(); i++) {
					int comp = list.get(i).weight;

					if (comp > cur.weight) {
						list.add(cur);
						list.remove(0);

						flag = true;
						break;
					}
				}

				if (flag) {
					continue;
				}

				cnt++;
				if (cur.idx == M) {
					break;
				} else {
					list.remove(0);
				}

			}

			System.out.println(cnt);

		}
	}

}
