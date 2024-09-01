import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 개수 T
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int j = 1;
            int x = a;
            while (true) {
                if ((x % a == 0) && (x % b == 0)) {
                    sb.append(x).append("\n");
                    break;
                }
                j++;
                x = a * j;
            }
        }
        System.out.print(sb);
        br.close();
    }
}
