import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        while (true) {
            if (isPrime(result) && isPalindrome(result)) {
                System.out.println(result);
                break;
            }
            result++;
        }
        br.close();
    }

    // 소수 판별 함수
    public static boolean isPrime(long x) {
        // 0과 1은 소수가 아님
        if (x == 0 || x == 1) return false;

        // 2와 3은 소수임
        if (x == 2 || x == 3) return true;

        // 2 또는 3으로 나누어 떨어지면 소수가 아님
        if (x % 2 == 0 || x % 3 == 0) return false;

        // 5부터는 6씩 더하며 소수 판별
        // 5부터는 소수가 [6K ± 1] 형태이기 때문
        for (long i = 5; i <= Math.sqrt(x); i += 6) {
            // i로 나눠 6k - 1 값을 판별하고
            // i+2로 나눠 6k + 1 값을 판별함
            if (x % i == 0 || x % (i + 2) == 0) return false;
        }

        // 소수일 경우 true 반환
        return true;
    }

    // 팰린드롬 판별 함수
    public static boolean isPalindrome(long x) {
        String num = String.valueOf(x);
        for (int i = 0; i < num.length(); i++) {
            if (!num.substring(i, i+1).equals(num.substring(num.length()-i-1, num.length()-i))) {
                return false;
            }
        }
        return true;
    }
}