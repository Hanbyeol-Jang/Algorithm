import java.util.Arrays;

public class CombiTest {

	static int[] num;
	static int it;

	public static void main(String[] args) {
		num = new int[3];
		combi(6, 3, 0, 0);
	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			it++;
			System.out.println("#" + it + " " + Arrays.toString(num));
			return;
		}

		// i: 0부터 -> 중복 허용
		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi(n, r, i + 1, count + 1);
		}

	}
}
