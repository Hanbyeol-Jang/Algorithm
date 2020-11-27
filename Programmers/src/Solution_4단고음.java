
public class Solution_4단고음 {

	public static void main(String[] args) {
		int n = 15;

		System.out.println(solution(n));
	}

	public static int cnt;
//	public static int num;
	static int[] num;

	public static int solution(int n) {
//		num = n;

		num = new int[2];
		combi2(15, 2, 0, 0);

		System.out.println(cnt);

		int answer = 0;
		return answer;
	}

	public static void combi2(int n, int r, int start, int count) {
		if (count == r) {
			cnt++;
			printArr(num);
			return;
		}

		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi2(n, r, i, count + 1);
		}

	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
