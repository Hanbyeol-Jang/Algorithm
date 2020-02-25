package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_9280 {

	static int TestCase;
	static int n, m;
	static int[] R_i;
	static int[] W_i;

	static int[] park;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCase = sc.nextInt();

		Queue<Integer> que = new LinkedList<>();

		for (int T = 1; T <= TestCase; T++) {	
			sum = 0;
			n = sc.nextInt();
			m = sc.nextInt();

			R_i = new int[n];
			W_i = new int[m];

			park = new int[n];

			for (int i = 0; i < n; i++) {
				R_i[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				W_i[i] = sc.nextInt();
			}

			for (int i = 0; i < m * 2; i++) {

				int carNum = sc.nextInt();

				if (carNum > 0) { // 입차
					int exist = 0; // 주자창 차 있는 지 확인 flag

					for (int j = 0; j < n; j++) {
						if (park[j] == 0) { // 주차장 비어있으면
							park[j] = carNum;
							exist = 1;
							break;
						}
					}

					if (exist == 0) { // 주차장 차 꽉 찼으면 Enqueue
						que.offer(carNum);
					}

				} else { // 출차

					int carNumOut = -carNum;

					for (int j = 0; j < n; j++) {
						if (park[j] == carNumOut) { // 주차장에서 해당 차 선택

							sum += R_i[j] * W_i[carNumOut - 1]; // 요금 합산

							que.remove(carNum);

							park[j] = 0; // 꺼냈으니 주차장 비움

							while (!que.isEmpty()) {
								park[j] = que.poll();	// Dequeue 후 주차장으로
								break;
							}

							break;
						}
					}

				}
			}

			System.out.println("#" + T + " " + sum);

		}

	}

}
