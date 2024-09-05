import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 수열 A를 담는 배열 arrA
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        double sum = 0;
        double count = 0;
        for (int j = 0; j < n; j++) {
            // 유클리드 호제법
            // 몫, 나머지
            int quotient = Math.min(x, arrA[j]);
            int remainder = Math.max(x, arrA[j]) % quotient;

            // 나머지가 0이 될때까지 반복
            while (remainder != 0) {
                int num = quotient;
                quotient = remainder;
                remainder = num % quotient;
            }

            // 유클리드 호제법 : 나머지가 0이 될 때의 몫이 바로 두 수의 최대공약수임
            // 따라서 두 수의 최대공약수가 1이면 두 수는 서로소이다.
            if (quotient == 1) {
                sum += arrA[j];
                count++;
            }
        }

        System.out.println(sum/count);
        br.close();
    }
}