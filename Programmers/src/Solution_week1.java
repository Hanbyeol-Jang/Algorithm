
public class Solution_week1 {

	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;

		System.out.println(solution(price, money, count));
	}

	public static long solution(int price, int money, int count) {
		long answer = -1;

		long sum = ((long) count * (long) price * (1 + count)) / 2;

		answer = sum - money;

		if (answer <= 0) {
			answer = 0;
		}

		return answer;
	}
}
