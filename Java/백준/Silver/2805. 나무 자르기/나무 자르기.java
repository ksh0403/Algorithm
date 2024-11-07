import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 이분탐색을 위해 배열을 오름차순으로 정렬

        int start = 0;
        int end = arr[n-1]; // 가장 긴 나무의 길이
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            // 자른 나무의 합 sum 계산
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] > mid) {
                    sum += arr[j] - mid;
                }
            }

            // sum 값에 따라 start, end 재설정
            if (sum >= m) {
                // 필요한 양보다 넉넉하게 잘린 경우
                result = mid; // 현재 값 저장
                start = mid + 1;
            } else {
                // 부족하게 잘린 경우
                end = mid - 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}