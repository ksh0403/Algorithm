import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        if (n >= m) {
            System.out.println(n - m);
        } else {
            System.out.println(m - n);
        }
    }
}