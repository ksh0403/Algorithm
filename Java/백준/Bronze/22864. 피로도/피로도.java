import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 네 정수 A, B, C, D
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // 피로도, 일한 양
        long tired = 0;
        long work = 0;

        for (long time = 0; time < 24; time++) {
            // A를 더했을 때 M을 넘지 않으면 일을 함
            if (tired + a <= m) {
                tired += a;
                work += b;
            } else {
                // M을 넘으면 쉼
                // 피로도가 음수로 내려가면 0이 됨
                if (tired - c < 0) {
                    tired = 0;
                } else {
                    tired -= c;
                }
            }
        }

        sb.append(work);
        System.out.println(sb);

        br.close();
    }
}