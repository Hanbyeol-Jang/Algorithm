import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_11651 {

	public static class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Location> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Location(x, y));
		}

		Collections.sort(list, (Location o1, Location o2) -> {
			if (o1.y > o2.y) {
				return 1;
			} else if (o1.y < o2.y) {
				return -1;
			} else {
				if (o1.x > o2.x) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
	}
}
