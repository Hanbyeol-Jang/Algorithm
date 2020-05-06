package KAKAO;

public class Solution_3 {

	static int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
//	static int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
	static int[][] lock = { { 1, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	static int N, M;

	public static void main(String[] args) {
		N = lock.length;
		M = key.length;

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				lock[i][j] += key[i][j];
//			}
//		}

		printMap(lock);
		rotate(lock);
		printMap(lock);
		rotate(lock);
		printMap(lock);
		rotate(lock);
		printMap(lock);

		rotate(lock);
		printMap(lock);

	}

	public static void rotate(int[][] m) {
		int len = m.length;

		for (int i = 0; i < len; i++) {
			int temp = m[0][i];

			m[0][i] = m[i][0];
			m[i][0] = m[len - 1 - i][i];
			m[len - 1 - i][i] = m[i][len - 1 - i];
			m[i][len - 1 - i] = temp;
		}

	}

	public static boolean checked(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lock[i][j] != 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

}
