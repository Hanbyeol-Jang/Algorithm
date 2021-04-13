import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static class Truck {
		int w;
		int idx;

		Truck(int w, int idx) {
			this.w = w;
			this.idx = idx;
		}
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> truckQue = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; i++) {
			truckQue.offer(truck_weights[i]);
		}

		LinkedList<Truck> list = new LinkedList<>();

		int time = 1;

		while (true) {
			if (truckQue.isEmpty() && list.isEmpty()) {
				break;
			}

			if (list.isEmpty()) {
				int truck = truckQue.poll();
				list.add(new Truck(truck, 0));
			} else {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).idx++;

					int idx = list.get(i).idx;
					if (idx >= bridge_length) {
						list.remove(i);
						i--;
					}
				}

				if (list.isEmpty()) {
					continue;
				}

				if (list.size() < bridge_length) {
					int sum = 0;
					for (int i = 0; i < list.size(); i++) {
						sum += list.get(i).w;
					}

					if (!truckQue.isEmpty()) {
						int temp = truckQue.peek();
						sum += temp;

						if (sum <= weight) {
							temp = truckQue.poll();
							list.add(new Truck(temp, 0));
						}
					}
				}
			}

			time++;
		}

		return time;
	}

}
