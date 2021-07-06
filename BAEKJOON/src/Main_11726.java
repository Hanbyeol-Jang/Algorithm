import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		if (n == 1 || n == 2) {
			System.out.println(n);
		} else {
			BigInteger[] db = new BigInteger[n + 1];

			db[0] = new BigInteger("0");
			db[1] = new BigInteger("1");
			db[2] = new BigInteger("2");

			for (int i = 3; i <= n; i++) {
				db[i] = db[i - 1].add(db[i - 2]);
			}

			System.out.println(db[n].remainder(new BigInteger("10007")));
		}
	}
}