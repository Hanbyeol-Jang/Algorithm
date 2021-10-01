public class Main_4673 {

	public static void main(String[] args) {

		boolean[] visited = new boolean[10001];

		for (int num = 1; num <= 10000; num++) {
			String s = num + "";
			int len = s.length();

			int sum = num;

			for (int i = 1; i <= len; i++) {
				sum += Integer.parseInt(s.charAt(i - 1) + "");
			}

			if (sum > 10000) {
				continue;
			}

			visited[sum] = true;
		}

		for (int i = 1; i <= 10000; i++) {
			if (!visited[i]) {
				System.out.println(i);
			}
		}

	}
}
