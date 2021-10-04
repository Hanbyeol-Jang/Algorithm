import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1455 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String s = st.nextToken();
			map[i] = s.toCharArray();
		}

		int cnt = 0;

		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (map[i][j] == '1') {
					cnt++;

					for (int k = 0; k <= i; k++) {
						for (int l = 0; l <= j; l++) {
							if (map[k][l] == '1') {
								map[k][l] = '0';
							} else {
								map[k][l] = '1';
							}
						}
					}
				}
			}
		}

		System.out.println(cnt);
	}

}
