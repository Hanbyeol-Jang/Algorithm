import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6550 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String test = br.readLine();

            if (test == null) {
                break;
            }

            st = new StringTokenizer(test);
            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;
            char c = s.charAt(idx);

            for (int i = 0; i < t.length(); i++) {
                char cur = t.charAt(i);

                if (cur == c) {
                    idx++;
                }

                if (idx == s.length()) {
                    break;
                }

                c = s.charAt(idx);
            }

            if (idx == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
