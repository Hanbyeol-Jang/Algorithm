import java.util.Arrays;

public class Solution_구명보트 {
	public static void main(String[] args) {
		int[] people = { 50, 70, 80 };
		int limit = 100;

		System.out.println(solution(people, limit));
	}

	public static int solution(int[] people, int limit) {
		int cnt = 0;
		int len = people.length;

		Arrays.sort(people);
		int min = 0;

		for (int i = len - 1; i >= min; i--) {
			if (people[min] + people[i] <= limit) {
				min++;
			}
			cnt++;
		}

		int answer = cnt;
		return answer;
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("===============");
	}
}
