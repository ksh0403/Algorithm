import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수의 개수 N
        int n = Integer.parseInt(br.readLine());

        // N개의 수 중 소수의 개수 count
        int count = 0;

        // N개의 수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 소수이면 count
            if (isPrime(num)) {
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);

        br.close();
    }

    // 소수 판별 함수
    public static boolean isPrime(int x) {
        // 0과 1은 소수가 아님
        if (x == 0 || x == 1) {
            return false;
        }

        // Math.sqrt() : 제곱근 함수
        for (int j = 2; j <= Math.sqrt(x); j++) {
            // 나누어 떨어지는 수(=약수)가 존재한다면 소수가 아님
            if (x % j == 0) {
                return false;
            }
        }

        // 약수가 존재하지 않으면 소수
        return true;
    }
}