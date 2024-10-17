import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer st_n = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st_n.nextToken());
        }
        Arrays.sort(arrA); // 이분탐색을 위해 배열을 오름차순으로 정렬

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st_m = new StringTokenizer(br.readLine(), " ");

        for (int j = 0; j < m; j++) {
            int num = Integer.parseInt(st_m.nextToken());
            boolean flag = false;
            int start = 0; // 탐색 범위의 시작 인덱스
            int end = n-1; // 탐색 범위의 끝 인덱스

            while (start <= end) {
                int mid = (start + end) / 2; // mid 인덱스 설정 (mid 값으로 num을 탐색함)
                if (arrA[mid] == num) { // num을 찾은 경우
                    sb.append(1).append("\n");
                    flag = true;
                    break;
                } else { // 못찾은 경우 num과 비교해 탐색 범위를 좁힘
                    if (arrA[mid] < num) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }

            // num을 찾지 못하고 while문을 나왔을 경우
            if (flag == false) {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}