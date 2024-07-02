import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 표준 입력을 위한 Scanner 객체
        Scanner input = new Scanner(System.in);

        // 공백을 기준으로 차례로 입력 받기
        int num_a = input.nextInt();
        int num_b = input.nextInt();

        // A * B 출력
        System.out.println(num_a * num_b);
    }
}