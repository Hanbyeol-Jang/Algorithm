import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1927 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1 > o2) {
				return 1;
			} else if (o1 < o2) {
				return -1;
			}
			return 0;
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			long cur = Long.parseLong(st.nextToken());

			if (cur == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.offer(cur);
			}
		}
	}

}