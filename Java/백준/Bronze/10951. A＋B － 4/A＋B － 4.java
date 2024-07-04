import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 리스트 생성
        List<Long> list = new ArrayList<>();

        // 다음 줄이 있는 동안 반복
        // (ctrl+z 나 ctrl+d 로 EOF처리하기 전까지 반복)
        while(sc.hasNextLong()) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            list.add(a + b);
        }

        for (Long ele : list) {
            System.out.println(ele);
        }
    }
}