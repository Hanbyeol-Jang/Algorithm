
public class Solution_이상한문자만들기 {

	public static void main(String[] args) {
		String s = "try hello world";

		System.out.println(solution(s));
	}

	public static String solution(String s) {
		int len = s.length();

		int cnt = 0;
		String[] arr = s.split("");
		s = "";
		for (int i = 0; i < len; i++) {
			if (arr[i].equals(" ")) {
				cnt = 0;
			} else {
				cnt += 1;
			}

			if (cnt % 2 == 0) {
				s += arr[i].toLowerCase();
			} else {
				s += arr[i].toUpperCase();
			}
		}

		String answer = s;
		return answer;
	}

}
