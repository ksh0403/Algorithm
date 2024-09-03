import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long t = Long.parseLong(br.readLine());

        // t만큼 반복
        for (long i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            long x = n;

            while (true) {
                // 소수이면 sb에 담고 while문 탈출
                if (isPrime(x)) {
                    sb.append(x).append("\n");
                    break;
                }
                x++;
            }
        }
        System.out.print(sb);
        br.close();
    }

    // 소수 판별 함수
    public static boolean isPrime(long x) {
        // 0과 1은 소수가 아님
        if (x == 0 || x == 1) {
            return false;
        }

        // Math.sqrt() : 제곱근 함수
        for (int j = 2; j <= Math.sqrt(x); j++) {
            // 약수가 존재하면 소수가 아님
            if (x % j == 0) {
                return false;
            }
        }

        // 약수가 존재하지 않으면 소수
        return true;
    }
}