import java.util.Stack;

public class Solution_괄호변환 {

	public static void main(String[] args) {
		String p = "()))((()";
		System.out.println(solution(p));
	}

	public static int pos;

	public static String solution(String p) {
		if (p.isEmpty()) {
			return p;
		}

		boolean same = isSame(p);
		String u = p.substring(0, pos);
		String v = p.substring(pos, p.length());

		if (same) {
			return u + solution(v);
		}

		String answer = "(" + solution(v) + ")";

		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				answer += ")";
			} else {
				answer += "(";
			}
		}

		return answer;
	}

	public static boolean isSame(String str) {
		boolean ret = true;
		int left = 0;
		int right = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
				stack.push('(');
			} else {
				right++;

				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					ret = false;
				}
			}

			if (left == right) {
				pos = i + 1; // u의 길이, v 의 시작위치 파악
				return ret;
			}
		}

		return true;

	}

}
