import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 리스트 생성
        List<Long> list = new ArrayList<>();

        long a;
        long b;

        // a와 b가 모두 0이 아니라면 반복
        do {
            a = sc.nextLong();
            b = sc.nextLong();

            list.add(a + b);
        } while (a != 0 && b != 0) ;

        // 리스트 마지막에 추가된 0을 제외하고 결과 출력
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i));
        }
    }
}