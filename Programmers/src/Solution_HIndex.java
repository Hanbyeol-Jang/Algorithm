import java.util.Arrays;

public class Solution_HIndex {

	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };

		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {

		Arrays.sort(citations);

		int hidx = 0;
		for (int h = 1; h <= 10000; h++) {
			int o = 0;
			int x = 0;

			for (int i = 0; i < citations.length; i++) {
				if (citations[i] >= h) {
					o++;
				} else if (citations[i] <= h) {
					x++;
				}
			}

			if (o >= h && x <= h) {
				hidx = h;
//				System.out.println("hidx: " + h);
//				System.out.println("h: " + h + " " + o + " " + x);
			}
		}
		int answer = hidx;
		return answer;
	}
}
