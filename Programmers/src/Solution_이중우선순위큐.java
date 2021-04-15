import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_이중우선순위큐 {

	public static void main(String[] args) {
//		String[] operations = { "I 16", "D 1" };
//		String[] operations = { "I 7", "I 5", "I -5", "D -1" };
		String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
//333,-45
		System.out.println(solution(operations));
	}

	public static int[] solution(String[] operations) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		int len = operations.length;
		String[] command = new String[len];
		int[] num = new int[len];

		for (int i = 0; i < len; i++) {
			char[] c = operations[i].toCharArray();
			command[i] = c[0] + "";

			StringBuilder sb = new StringBuilder();
			for (int j = 2; j < c.length; j++) {
				sb.append(c[j]);
			}
			num[i] = Integer.parseInt(sb.toString());

			System.out.println(command[i] + " " + num[i]);
		}

		for (int i = 0; i < len; i++) {
			if (command[i].equals("I")) {
				pq.offer(num[i]);
			} else {
				if (num[i] < 0) {
					pq.poll();
				} else {
					System.out.println("!!");

					int size = pq.size();
					for (int j = 0; j < size; j++) {
						if (!pq.isEmpty()) {
							int temp = pq.poll();
							pq2.offer(temp);
							System.out.println("temp: " + temp);
						}
					}

					pq2.poll();

					int size2 = pq2.size();
					for (int j = 0; j < size2; j++) {
						if (!pq2.isEmpty()) {
							pq.offer(pq2.poll());
						}
					}
				}
			}

			PriorityQueue<Integer> pqTemp = new PriorityQueue<>(pq);

			while (!pqTemp.isEmpty()) {
				System.out.println(pqTemp.poll());
			}
			System.out.println("===================");
		}

		int[] answer = new int[2];

		if (pq.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[1] = pq.poll();

			while (pq.size() > 1) {
				pq.poll();
			}
			answer[0] = pq.poll();
		}

		System.out.println(answer[0] + " " + answer[1]);

		return answer;
	}
}
