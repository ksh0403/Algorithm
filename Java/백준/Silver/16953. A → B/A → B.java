import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long count = 0;

        while (a != b && b > a) {
            if (b % 10 == 1) {
                b /= 10;
                count++;
            } else if (b % 2 == 0) {
                b /= 2;
                count++;
            } else {
                System.out.println(-1);
                return;
            }
        }

        if (a == b) System.out.println(count + 1);
        else System.out.println(-1);
        br.close();
    }
}