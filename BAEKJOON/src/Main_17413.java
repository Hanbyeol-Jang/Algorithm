import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			if (cur == '<') {
				while (!stack.isEmpty()) {
					char temp = stack.pop();
					sb.append(temp);
				}

				flag = true;
				sb.append(cur);
				continue;
			} else if (cur == '>') {
				flag = false;
				sb.append(cur);
				continue;
			} else if (cur != ' ') {
				if (!flag) {
					stack.push(cur);
				}
			} else {
				if (!flag) {
					while (!stack.isEmpty()) {
						char temp = stack.pop();
						sb.append(temp);
					}
					sb.append(' ');
				}
			}

			if (flag) {
				sb.append(cur);
			}
		}

		while (!stack.isEmpty()) {
			char temp = stack.pop();
			sb.append(temp);
		}

		System.out.println(sb);

	}
}