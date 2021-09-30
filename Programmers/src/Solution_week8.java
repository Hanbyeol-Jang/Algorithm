import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_week8 {

	public int solution(int[][] sizes) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < sizes.length; i++) {

			if (sizes[i][0] >= sizes[i][1]) {
				list1.add(sizes[i][0]);
				list2.add(sizes[i][1]);
			} else {
				list1.add(sizes[i][1]);
				list2.add(sizes[i][0]);
			}
		}

		Collections.sort(list1, Collections.reverseOrder());
		Collections.sort(list2, Collections.reverseOrder());

		int answer = list1.get(0) * list2.get(0);
		return answer;
	}
}