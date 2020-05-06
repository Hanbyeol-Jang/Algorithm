package KAKAO;

public class Solution_1 {

	static String s = "ababcdcdababcdcd";

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder(s);
//		int len = sb.length();

		StringBuilder c = new StringBuilder(s);

		String s = c.charAt(0) + "";
		String first = c.charAt(0) + "";

		for (int i = 1; i < c.length(); i++) {
			if (!first.equals(c.charAt(i) + "")) {
				s += c.charAt(i);
			} else {
				int len = s.length();
				int cnt = 0;
				for (int j = 0; j < len; j++) {
					if (s.charAt(j) == c.charAt(i + j)) {
						cnt++;
					}
				}
				if (cnt == len) {
					System.out.println(s + " " + i);
					break;
				} else {
					s += c.charAt(i);
				}

			}
		}

//		for (int box = 1; box <= len; box++) {
//
//			for (int i = 0; i < args.length; i++) {
//				
//			}
//			
//			String sub = "";
//			if (box * 2 - 1 < len) {
//				sub = sb.substring(box - 1, box * 2 - 1);
//
//			}
//			System.out.println(sub);
//		}
//		System.out.println("ddd");
	}

}
