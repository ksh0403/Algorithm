import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();

        // 리스트 생성
        List<Long> list = new ArrayList<>();

        // 테스트 케이스마다 더한 결과를 리스트에 저장
        for (int i = 1; i <= t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            list.add(a + b);
        }

        // 리스트를 조회하여 결과 출력
        for (Long ele : list) {
            System.out.println(ele);
        }
    }
}