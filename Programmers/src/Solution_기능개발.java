import java.util.*;

public class Solution_기능개발 {

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		System.out.println(solution(progresses, speeds));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int len = progresses.length;
		int[] time = new int[len];
		List<Integer> list = new LinkedList<>();
		Queue<Integer> que = new LinkedList<>();

		for (int i = 0; i < len; i++) {
			time[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
			que.offer(time[i]);
		}

		while (!que.isEmpty()) {
			int cnt = 1;
			int temp = que.poll();

			while (!que.isEmpty()) {
				int next = que.peek();

				if (temp >= next) {
					cnt++;
					que.poll();
				} else {
					break;
				}

			}

			list.add(cnt);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
