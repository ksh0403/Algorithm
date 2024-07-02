import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 표준 입력을 위한 Scanner 객체
        Scanner sc = new Scanner(System.in);

        // 공백을 기준으로 차례로 입력 받기
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        // A + B + C
        System.out.println(a + b + c);
    }
}