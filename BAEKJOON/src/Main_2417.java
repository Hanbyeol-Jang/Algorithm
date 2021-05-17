import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2417 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Long N = Long.parseLong(st.nextToken());

		long left = 0;
		long right = N;
		long mid = 0;

		long min = Long.MAX_VALUE;

		while (left <= right) {
			mid = (left + right) >> 1;

			long pow = (long) Math.pow(mid, 2);

			if (pow >= N) {
				right = mid - 1;
				min = Math.min(min, mid);
			} else {
				left = mid + 1;
			}
		}

		System.out.println(min);
	}

}