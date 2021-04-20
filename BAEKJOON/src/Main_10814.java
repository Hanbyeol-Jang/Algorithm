import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10814 {

	public static class OldName {
		int old;
		String name;

		OldName(int old, String name) {
			this.old = old;
			this.name = name;
		}

	}

	public static ArrayList<OldName> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int num = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			list.add(new OldName(num, s));
		}

		Collections.sort(list, (OldName o1, OldName o2) -> {
			if (o1.old > o2.old) {
				return 1;
			} else if (o1.old < o2.old) {
				return -1;
			}

			return 0;
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).old + " " + list.get(i).name);
		}
	}
}
