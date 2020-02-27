import java.util.Arrays;
import java.util.Scanner;

public class ComPerm {

	static int N, R, M;
	static int[] num;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		M = sc.nextInt();

		num = new int[R];

		switch (M) {
		case 1:
			combi(N, R, 0, 0);
			break;
		case 2:
			combi2(N, R, 0, 0);
			break;
		case 3:
			perm2(N, R, 0, 0);
			break;
		case 4:
			perm(N, R, 0, 0);
			break;
		}

		System.out.println(cnt);
	}

	// 조합
	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			cnt++;
			printArr(num);
			return;
		}

		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi(n, r, i + 1, count + 1);
		}

	}

	// 중복 조합
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

	// 중복 순열
	public static void perm2(int n, int r, int flag, int count) {
		if (count == r) {
			cnt++;
			printArr(num);
			return;
		}

		for (int i = 0; i < n; i++) {
			num[count] = i + 1;
			perm2(n, r, i + 1, count + 1);
		}

	}

	// 순열
	public static void perm(int n, int r, int flag, int count) {
		if (count == r) {
			cnt++;
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

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
