import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        // 미리 피보나치 수를 저장
        int[] fibo = new int[41];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= 40; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        for (int j = 0; j < t; j++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("1 0").append("\n");
            } else if (n == 1) {
                sb.append("0 1").append("\n");
            } else {
                sb.append(fibo[n-1] + " " + fibo[n]).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}