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
            long x = Long.parseLong(br.readLine());
            while(!isPrime(x)) {
                x++;
            }
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }

    // 소수 판별 함수
    static boolean isPrime(long num) {
        // 0과 1은 소수가 아님
        if (num < 2) return false;

        // 2와 3은 소수임
        if (num == 2 || num == 3) return true;

        // 2 또는 3으로 나누어 떨어지면 소수가 아님
        if (num % 2 == 0 || num % 3 == 0) return false;

        // 5부터는 6씩 더하며 소수 판별
        // 5부터는 소수가 [6k +- 1] 형태이기 때문
        for (long i = 5; i <= Math.sqrt(num); i += 6) {
            // i 로 나눠 6k - 1 값을 판별하고
            // i+2 로 나눠 6k + 1 값을 판별함
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }

        // 소수일 경우 true 반환
        return true;
    }
}