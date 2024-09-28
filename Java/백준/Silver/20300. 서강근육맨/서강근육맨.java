import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long[] arr_t = new Long[n];
        for (int i = 0; i < n; i++) {
            arr_t[i] = Long.parseLong(st.nextToken());
        }

        // 배열 arr_t 정렬
        Arrays.sort(arr_t);

        long m = 0;
        if (arr_t.length % 2 == 0) {
            // 운동기구의 수가 짝수인 경우
            for (int j = 0; j < n/2; j++) {
                long current = arr_t[j] + arr_t[arr_t.length-1-j];
                if (current > m) {
                    m = current;
                }
            }
        } else {
            // 홀수인 경우
            m = arr_t[arr_t.length-1];
            for (int j = 0; j < n/2; j++) {
                long current = arr_t[j] + arr_t[arr_t.length-2-j];
                if (current > m) {
                    m = current;
                }
            }
        }

        System.out.println(m);
        br.close();
    }
}
