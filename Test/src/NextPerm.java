import java.util.Arrays;

public class NextPerm {

	static int[] p = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {

		do {
			System.out.println(Arrays.toString(p));
		} while (np(p.length - 1));

	}

	// 몇개 정렬?
	public static boolean np(int size) {
		int i = size; // size = length -1

		// 증가하는걸 찾아, 맨 오른쪽 부터 (꼭대기 위치를 찾아)
		while (i > 0 && p[i - 1] > p[i]) {
			i--;
		}

		if (i == 0) { // 더 이상 진행X, 가장 큼
			return false; // 5, 4, 3, 2,1로 됨
		}

		int j = size;

		// 첫번째를 찾아라
		while (p[i - 1] >= p[j]) {
			j--;
		}

		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;

		int k = size;
		while (i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}

		// 여기까지 내려오면 문제없이 내려옴
		return true;
	}
}
