import java.util.Arrays;
import java.util.Scanner;

public class Main_2750 {

//	public static int[] num = { 5, 5, 2, 3, 4, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] num = new int[len];

		for (int i = 0; i < len; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}

	}
}
