import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Collections.reverseOrder()를 사용하기 위해 Integer 배열 사용
        // (int 배열에서는 작동하지 않음)
        Integer arr[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // arr를 내림차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        // 최대 중량 계산
        long maxWeight = 0;
        for (int i = 0; i < n; i++) {
            // (i + 1)개 로프를 사용하고, 최소 중량은 arr[i]
            long currentWeight = (long)(i + 1) * arr[i];
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
        }

        System.out.println(maxWeight);
        br.close();
    }
}
