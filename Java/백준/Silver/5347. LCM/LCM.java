import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());

        StringTokenizer st;
        for (long i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            // 최소공배수
            long LCM = 0;
            long j = a;
            long k = 1;
            while (true) {
                if ((j % a == 0) && (j % b == 0)) {
                    LCM = j;
                    break;
                }
                k++;
                j = a * k;
            }
            sb.append(LCM).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
