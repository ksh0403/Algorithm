import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[n];
        int arr_sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr_sum += arr[i];
        }

        // arr 배열을 내림차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        int count_3 = 0;
        int discount = 0;
        for (int j = 0; j < n; j++) {
            count_3++;
            if (count_3 == 3) {
                discount += arr[j];
                count_3 = 0;
            }
        }

        System.out.println(arr_sum - discount);
        br.close();
    }
}