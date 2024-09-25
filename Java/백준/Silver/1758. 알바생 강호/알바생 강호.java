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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // arr 배열 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        long tip_sum = 0;
        for (int j = 0; j < n; j++) {
            int tip = arr[j] - j;
            if (tip > 0) {
                tip_sum += tip;
            }
        }

        System.out.println(tip_sum);
        br.close();
    }
}