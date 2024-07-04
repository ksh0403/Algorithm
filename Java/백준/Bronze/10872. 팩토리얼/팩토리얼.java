import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        int result = 1;

        if (n == 0) { // N이 0일 때
            System.out.println(result);
        } else { // N이 0이 아닐 때
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            System.out.println(result);
        }
    }
}