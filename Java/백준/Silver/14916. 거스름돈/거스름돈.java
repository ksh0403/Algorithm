import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 1이거나 3일 경우 거슬러 줄 수 없음
        if (n == 1 || n == 3) {
            System.out.println(-1);
        } else {
            int last_num = n % 10;

            switch (last_num) {
                case 0:
                case 5:
                    System.out.println(n/5);
                    break;
                case 1:
                case 6:
                    System.out.println(3 + (n-6)/5);
                    break;
                case 2:
                case 7:
                    System.out.println(1 + (n-2)/5);
                    break;
                case 3:
                case 8:
                    System.out.println(4 + (n-8)/5);
                    break;
                case 4:
                case 9:
                    System.out.println(2 + (n-4)/5);
                    break;
            }
        }
        br.close();
    }
}