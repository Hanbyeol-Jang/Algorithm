import java.util.PriorityQueue;

public class Solution_더맵게 {
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;

		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			pq.offer(scoville[i]);
		}

		int time = 0;

		while (true) {
			if (pq.isEmpty() || pq.peek() >= K) {
				break;
			}

			int a = pq.poll();

			if (pq.isEmpty()) {
				break;
			}
			int b = pq.poll();

			int mix = a + b * 2;

			pq.offer(mix);
			time++;

			if (pq.size() == 1 && pq.peek() < K) {
				time = -1;
				break;
			}
		}
		return time;
	}
}
