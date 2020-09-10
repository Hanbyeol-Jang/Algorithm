import java.util.LinkedList;

public class Solution_후보키 {

	public static void main(String[] args) {
		String[][] relation = { { "200", "ryan", "music", "2" }, { "100", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println(solution(relation));
	}

	public static LinkedList<String> list;
	public static int[] num;
	public static int cnt;
	public static LinkedList<String> candidate;
	public static String[][] relation2;
	public static int N;

	public static int solution(String[][] relation) {
		relation2 = relation;
		printRelation(relation2);
		list = new LinkedList<>();
		candidate = new LinkedList<>();

		for (int j = 0; j < relation[j].length; j++) {
			boolean flag = false;

			for (int i = 0; i < relation.length; i++) {
				String str = relation[i][j];

				if (!list.contains(str)) {

					list.add(str);
				} else {
					flag = true;
//					System.out.println("후보키 안됨! " + str);
					break;
				}
			}

			if (!flag) {
				candidate.add(j + "");
			}
//			System.out.println();
//			candidate.add(j);
		}

//		System.out.println("*********  list *********");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
//		System.out.println("******************");

		N = relation.length;
		int r = relation[0].length;

		for (int i = 2; i < r; i++) {
			num = new int[i];
			combi(r, i, 0, 0);
		}

		System.out.println("********* candidate ***********");
		for (int i = 0; i < candidate.size(); i++) {
			System.out.println(candidate.get(i));
		}
		System.out.println("********************");

		System.out.println("answer");
		int answer = candidate.size();
		return answer;
	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			cnt++;
			printArr(num);

			StringBuilder temp = new StringBuilder();

			for (int i = 0; i < num.length; i++) {
				temp.append(num[i] + "");
			}

			for (int i = 0; i < candidate.size(); i++) {
				if (temp.toString().contains(candidate.get(i))) {
					return;
				}
			}

			checked(num);
//			System.out.println(temp);

			return;
		}

		for (int i = start; i < n; i++) {
			if (candidate.contains(i + "")) {
				continue;
			}

			num[count] = i;
			combi(n, r, i + 1, count + 1);
		}

	}

	public static void checked(int[] num) {
		StringBuilder sb = new StringBuilder();
		StringBuilder candidateIdx = new StringBuilder();
		list = new LinkedList<>();

		boolean flag = false;

		for (int i = 0; i < num.length; i++) {
			candidateIdx.append(num[i]);
		}

		for (int j = 0; j < N; j++) {
			sb = new StringBuilder();

			for (int i = 0; i < num.length; i++) {
				sb.append(relation2[j][num[i]]);
			}

			if (!list.contains(sb.toString())) {
				list.add(sb.toString());
			} else {
				flag = true;
				System.out.println("후보키 안됨! " + sb);
			}
			System.out.println(sb);
		}

		if (!flag) {
			candidate.add(candidateIdx.toString());
		}

//		for (int j = 0; j < relation2[j].length; j++) {
//			boolean flag = false;
//
//			for (int i = 0; i < relation2.length; i++) {
//				String str = relation2[i][j];
//
//				if (!list.contains(str)) {
//					list.add(str);
//				} else {
//					flag = true;
////					System.out.println("후보키 안됨! " + str);
//					break;
//				}
//			}
//			if (!flag) {
//				candidate.add(j + "");
//			}
//		}
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void printRelation(String[][] s) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				System.out.print(s[i][j] + "\t\t");
			}
			System.out.println();
		}
		System.out.println("============================================================");

	}

}
