import java.util.Arrays;

public class Perm {

	static int[] num;
	static int it;

	public static void main(String[] args) {
		num = new int[3];
		perm(6, 3, 0, 0);
	}

	public static void perm(int n, int r, int flag, int count) {
		if (count == r) {
			it++;
			System.out.println("#" + it + " " + Arrays.toString(num));
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) == 0) {
				num[count] = i + 1;
				perm(n, r, flag | 1 << i, count + 1);
			}

		}
	}
}
