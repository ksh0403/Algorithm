import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer arr[] = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 배열을 오름차순으로 정렬
        Arrays.sort(arr);

        long sum = arr[0];
        for (int j = 1; j < n; j++) {
            arr[j] += arr[j-1];
            sum += arr[j];
        }

        System.out.println(sum);
        br.close();
    }
}