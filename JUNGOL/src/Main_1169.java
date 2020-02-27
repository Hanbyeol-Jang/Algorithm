import java.util.Scanner;

public class Main_1169 {

	static int N, M;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		num = new int[N];

		if (M == 1) {
			combi(6, N, 0, 0);
		} else if (M == 2) {
			combi2(6, N, 0, 0);
		} else if (M == 3) {
			perm(6, N, 0, 0);
		}

	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			printArr(num);
			return;
		}

		for (int i = 0; i < n; i++) {
			num[count] = i + 1;
			combi(n, r, i, count + 1);
		}

	}

	public static void combi2(int n, int r, int start, int count) {
		if (count == r) {
			printArr(num);
			return;
		}

		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi2(n, r, i, count + 1);
		}
	}

	public static void perm(int n, int r, int flag, int count) {
		if (count == r) {
			printArr(num);
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) == 0) {
				num[count] = i + 1;
				perm(n, r, flag | 1 << i, count + 1);
			}

		}
	}

	public static void printArr(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}
}
