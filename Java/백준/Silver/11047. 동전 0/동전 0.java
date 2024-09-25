import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long k  = Long.parseLong(st.nextToken());

        Long arr[] = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // arr 배열을 내림차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        long count = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] <= k) {
                count += k / arr[j];
                k = k % arr[j];

                if (k == 0) break;
            }
        }

        System.out.println(count);
        br.close();
    }
}