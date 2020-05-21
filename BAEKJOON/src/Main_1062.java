import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1062 {

	static int N; // 남극 단어 N개
	static int K; // K개의 글자 가르침

	static boolean[] visited;
	static int[] num;
	static LinkedList<Integer> alphaList;
	static LinkedList<String> dicList;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		num = new int[K];
		visited = new boolean[26];
		alphaList = new LinkedList<>();
		dicList = new LinkedList<>();

		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			StringBuilder s = new StringBuilder(sc.next());
			s.delete(0, 4);
			s.delete(s.length() - 4, s.length());

			String sds = "";
			dicList.add(s.toString());
			for (int j = 0; j < s.length(); j++) {
				visited[s.charAt(j) - '0' - 49] = true;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (!visited[i]) {
				continue;
			}
			alphaList.add(i);
		}

//		int size = dicList.size();
//		for (int i = 0; i < size; i++) {
//			System.out.println(dicList.get(i) + " ");
//		}
//		System.out.println();

		int size = alphaList.size();
		combi(size, K, 0, 0);
		System.out.println(max);
	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {

			int maxCnt = 0;

			for (int i = 0; i < dicList.size(); i++) {
				if (isContain(i)) {
					maxCnt++;
				} else {
//					System.out.print("***");
//					System.out.print(dicList.get(i));
//					System.out.println("***");
				}
			}

			max = Math.max(max, maxCnt);

//			for (int i = 0; i < K; i++) {
//				System.out.print((char) (alphaList.get(num[i] - 1) + 97) + " ");
//			}
//			System.out.println();
//			System.out.println("========================");

			return;
		}

		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi(n, r, i + 1, count + 1);
		}

	}

	public static boolean isContain(int i) {
		int len = dicList.get(i).length();
		int cnt = 0;

		for (int j = 0; j < K; j++) {
			if (dicList.get(i).contains(Character.toString((char) (alphaList.get(num[j] - 1) + 97)))) {
//				System.out.println(Character.toString((char) (alphaList.get(num[j] - 1) + 97)));

				cnt++;
			}
		}

		if (cnt == len) {
			return true;
		} else {
			return false;
		}
	}
}
