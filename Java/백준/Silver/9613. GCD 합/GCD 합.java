import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }

            // n개의 수들의 가능한 모든 쌍의 GCD의 합 구하기
            long gcd_sum = 0;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    // 자기자신은 건너뜀
                    if (a == b) {
                        continue;
                    }

                    // 유클리드 호제법
                    // 몫, 나머지
                    int quotient = Math.min(input[a], input[b]);
                    int remainder = Math.max(input[a], input[b]) % quotient;

                    // 나머지가 0이 될때까지 반복
                    while (remainder != 0) {
                        int num = quotient;
                        quotient = remainder;
                        remainder = num % quotient;
                    }

                    // 유클리드 호제법 : 나머지가 0이 될 때의 몫이 바로 두 수의 최대공약수임
                    gcd_sum += quotient;
                }
            }
            // 두 쌍씩 합해져있으므로 gcd_sum을 2로 나눔
            sb.append(gcd_sum/2).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}