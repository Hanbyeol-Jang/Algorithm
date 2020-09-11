
public class Solution_문자열압축 {

	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede";
		System.out.println(solution(s));
	}

	public static StringBuilder sb;

	public static int solution(String s) {
		int answer = s.length();
		int len = s.length();

		for (int i = 1; i <= len / 2; i++) {
			int pos = 0; // 위치
			int result = s.length();

			for (; pos + i <= len;) {
				String unit = s.substring(pos, pos + i);
				pos += i;

				int cnt = 0;

				for (; pos + i <= len;) {
					if (unit.equals(s.substring(pos, pos + i))) {
						cnt++;
						pos += i;
					} else {
						break;
					}
				}

				if (cnt > 0) {
					result -= i * cnt;

					if (cnt < 9) {
						result += 1;
					} else if (cnt < 99) {
						result += 2;
					} else if (cnt < 999) {
						result += 3;
					} else {
						result += 4;
					}
				}
			}

			answer = Math.min(answer, result);
		}

		return answer;
	}
}
