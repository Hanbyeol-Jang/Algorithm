import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			boolean flag = false;

			char[] c = br.readLine().toCharArray();

			for (int j = 0; j < c.length; j++) {

				if (c[j] == '(') {
					stack.push(c[j]);
				} else {

					if (!stack.isEmpty()) {

						char temp = stack.peek();

						if (temp == '(') {
							stack.pop();
							continue;
						} else {
							System.out.println("NO");
							flag = true;
							break;
						}
					} else {
						System.out.println("NO");
						flag = true;
						break;
					}
				}
			}

			if (!flag) {
				if (!stack.isEmpty()) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}

		}
	}
}
