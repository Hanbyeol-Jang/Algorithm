import java.util.Arrays;

public class CombiSelect {

	static int[] com = { 1, 2, 3, 4, 5, 6 };
	static boolean[] isc;
	static int cnt;

	public static void main(String[] args) {
		int n = 6;
		int r = 3;
		isc = new boolean[n];// false
		nCr(n, r, 0, 0);
		System.out.println(cnt);
	}

	public static void nCr(int n, int r, int start, int count) {
		if (count == r) {
			cnt++;
			for (int i = 0; i < isc.length; i++) {
				if (isc[i]) {
					System.out.print(com[i] + " ");
				}
			}
			System.out.print(" ||  ");
			for (int i = 0; i < isc.length; i++) {
				if (!isc[i]) {
					System.out.print(com[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isc[i]) {
				isc[i] = true;
				nCr(n, r, i + 1, count + 1);
				isc[i] = false;
			}
		}

	}

}