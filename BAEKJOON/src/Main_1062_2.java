import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main_1062_2 {

	static int N; // 남극 단어 N개
	static int K; // K개의 글자 가르침

	static boolean[] visited;
	static int[] num;
	static LinkedList<Integer> alphaList;
	static LinkedList<String> dicList;
	static int max;
	static int total;
	static int antatica;

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
			System.out.println(s);
			dicList.add(s.toString());

			visited[0] = true; // a
			visited[2] = true; // c
			visited[8] = true; // i
			visited[13] = true; // n
			visited[19] = true; // t

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

		for (int i = 0; i < alphaList.size(); i++) {
			System.out.print((char) (alphaList.get(i) + 97) + " ");
		}
		System.out.println();

		int size = alphaList.size();
		combi(size, K, 0, 0);
		System.out.println(max);
		System.out.println(total);
	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
			total++;
			int maxCnt = 0;
			int len = 0;
			int cnt = 0;
			for (int i = 0; i < dicList.size(); i++) {
				len = dicList.get(i).length();
				cnt = 0;
				for (int j = 0; j < K; j++) {
					if (dicList.get(i).contains(Character.toString((char) (alphaList.get(num[j] - 1) + 97)))) {
//						System.out.println(
//								dicList.get(i) + " " + Character.toString((char) (alphaList.get(num[j] - 1) + 97)));
//						System.out.println("==================");
						cnt++;
						continue;
					}
				}

				if (cnt == len) {
					maxCnt++;
				}

			}

			max = Math.max(max, maxCnt);

			return;
		}

		for (int i = start; i < n; i++) {
			num[count] = i + 1;
			combi(n, r, i + 1, count + 1);
		}

	}

}
