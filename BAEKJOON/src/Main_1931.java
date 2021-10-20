import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1931 {

    public static class Meet {
        int start;
        int end;

        Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Meet> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.end > o2.end) {
                return 1;
            } else if (o1.end < o2.end) {
                return -1;
            } else {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start) {
                    return -1;
                }
            }

            return 0;
        });

        int cnt = 1;
        Meet prev = list.get(0);

        for (int i = 1; i < N; i++) {
            if(list.get(i).start >=prev.end ){
                cnt++;
                prev = list.get(i);
            }
        }

        System.out.println(cnt);
    }
}
