import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int x = -1;
        int count = 0;

        while (x != n) {
            if (count == 0) {
                // 첫 실행
                x = (n%10)*10 + ((n/10 + n%10)%10);
            } else {
                // 이후 실행
                x = (x%10)*10 + ((x/10 + x%10)%10);
            }
            count++;
        }

        System.out.println(count);
        br.close();
    }
}