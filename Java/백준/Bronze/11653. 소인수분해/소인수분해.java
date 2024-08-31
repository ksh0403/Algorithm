import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());
        long i = 2;

        if (n == 1) {
            return;
        } else {
            while (n != 1) {
                if (n % i == 0) {
                    sb.append(i).append("\n");
                    n /= i;
                } else {
                    i++;
                }
            }
        }

        System.out.print(sb);
        br.readLine();
    }
}