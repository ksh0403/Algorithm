import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        primeNumber(n,k);
    }

    // 에라토스테네스의 체 알고리즘
    static void primeNumber(int n, int k) {
        // n까지 저장할 수 있는 배열 선언
        int[] arr = new int[n+1];

        // 배열 초기화
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            // 이미 지운 수는 건너뛰기
            if (arr[i] == 0) continue;

            // 배수들 지우기
            for (int j = i; j <= n; j+=i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    k--;

                    // k번째로 지운 수 출력
                    if (k == 0) {
                        System.out.print(j);
                        return;
                    }
                }
            }
        }
    }
}