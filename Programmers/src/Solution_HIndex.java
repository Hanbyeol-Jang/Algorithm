import java.util.Arrays;

public class Solution_HIndex {
	public static void main(String[] args) {

		int[] citations = { 3, 0, 6, 1, 5 };

		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {

		Arrays.sort(citations);

		int h = 0;
		for (h = citations[citations.length - 1]; h >= 0; h--) {

			int up = 0;
			int dw = 0;

			for (int j = 0; j < citations.length; j++) {

				if (citations[j] >= h) {
					up++;
				} else if (citations[j] <= h) {
					dw++;
				}
			}

			if (up >= h && dw <= h) {
				break;
			}
		}

		int answer = h;
		return answer;
	}

}
