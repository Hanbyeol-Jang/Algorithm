import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_2839 {

	static int M; // 배달해야할 kg
	static int[] num; // 조합 담을 arr
	static LinkedList<Integer> list; // 봉지 담을 list

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		num = new int[2]; // 3kg or 5kg
		list = new LinkedList<Integer>(); // 매 test case 마다 init
		combi(1700, 2, 0, 0);

		if (!list.isEmpty()) { // list가 비어있다면 정확하게 M kg가 될수 없으니
			Collections.sort(list); // list 오름차순 정렬 후 맨 앞 요소(최소값) 출력
			System.out.println(list.get(0));
		} else {
			System.out.println(-1);
		}

	}

	public static void combi(int n, int r, int start, int count) {
		if (count == r) {
//			printArr(num);
			if (num[0] * 3 + num[1] * 5 == M) { // 정확하게 M kg 되면
				list.add(num[0] + num[1]); // 갯수만 list에 추가
			}
			return;
		}

		for (int i = 0; i <= n; i++) {
			num[count] = i; // 봉지가 하나도 안담길 수 있으니 0부터 시작
			combi(n, r, i, count + 1); // count 하나씩 늘려가며 combi 확인
		}
	}

	public static void printArr(int[] n) { // 배열 요소 출력
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}
}