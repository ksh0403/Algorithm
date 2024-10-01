import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        String num = br.readLine();
        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(num.substring(i, i+1));
        }
        System.out.println(sum);
        br.close();
    }
}