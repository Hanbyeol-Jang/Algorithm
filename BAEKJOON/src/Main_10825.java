import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10825 {

	public static class Student {
		String name;
		int kor;
		int eng;
		int math;

		Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Student> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			list.add(new Student(name, kor, eng, math));
		}

		Collections.sort(list, (Student o1, Student o2) -> {
			if (o1.kor < o2.kor) {
				return 1;
			} else if (o1.kor > o2.kor) {
				return -1;
			} else {
				if (o1.eng > o2.eng) {
					return 1;
				} else if (o1.eng < o2.eng) {
					return -1;
				} else {
					if (o1.math < o2.math) {
						return 1;
					} else if (o1.math > o2.math) {
						return -1;
					} else {
						return o1.name.compareTo(o2.name);
					}
				}
			}
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).name);
		}
	}
}
