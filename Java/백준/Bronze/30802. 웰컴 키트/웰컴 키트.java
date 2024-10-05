import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] size = new long[6];
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        long t = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());

        long t_shirt = 0;

        // 티셔츠 묶음 계산
        for (int j = 0; j < 6; j++) {
            if (size[j] % t == 0) {
                t_shirt += size[j] / t;
            } else {
                t_shirt += size[j] / t + 1;
            }
        }

        System.out.println(t_shirt);
        System.out.println(n/p + " " + n%p);
        br.close();
    }
}