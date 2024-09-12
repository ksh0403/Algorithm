import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 소수를 담는 리스트
        LinkedList<Long> primeList = new LinkedList<>();
        for (long i = 0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());
            if (isPrime(num)) {
               primeList.add(num);
            }
        }

        if (primeList.isEmpty()) {
            System.out.println(-1);
        } else {
            // 소수는 1과 자기자신만을 약수로 가짐
            // 따라서 소수들의 최소공배수는 각 수를 곱한 값
            long LCM = 1;
            for (long e : primeList) {
                // 그러나 수열에서 중복 없음이 보장되지 않기 때문에 중복 검사 시행
                if (LCM % e != 0) {
                    LCM *= e;
                }
            }
            System.out.println(LCM);
        }
        br.close();
    }

    // 소수 판별 함수
    public static boolean isPrime(long x) {
        // 0과 1은 소수가 아님
        if (x < 2) return false;

        // 2와 3은 소수임
        if (x == 2 || x == 3) return true;

        // 2 또는 3으로 나누어 떨어지면 소수가 아님
        if (x % 2 == 0 || x % 3 == 0) return false;

        // 5부터는 6씩 더하며 소수 판별
        // 5부터는 소수가 [6k ± 1] 형태이기 때문
        for (long i = 5; i <= Math.sqrt(x); i += 6) {
            // i로 나눠 6k - 1 값을 판별하고
            // i+2로 나눠 6k + 1 값을 판별함
            if (x % i == 0 || x % (i + 2) == 0) return false;
        }

        // 소수일 경우 true 반환
        return true;
    }
}
