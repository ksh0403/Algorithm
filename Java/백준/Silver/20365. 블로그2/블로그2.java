import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] color = new String[n];
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            color[i] = input.substring(i, i+1);
        }

        int count_B_base = 1; // 베이스 색 칠하는 횟수 1번
        int count_R_base = 1; // 베이스 색 칠하는 횟수 1번

        for (int i = 1; i < n; i++) {
            // 시작 색
            if (i == 1) {
                if (color[i-1].equals("R")) {
                    count_B_base++;
                } else {
                    count_R_base++;
                }
            }

            // count_B_base 계산 : Blue로 전부 칠해놓고 R 작업의 수를 셈
            if (color[i].equals("R") && color[i-1].equals("B")) {
                count_B_base++;
            }

            // count_R_base 계산 : Red로 전부 칠해놓고 B 작업의 수를 셈
            if (color[i].equals("B") && color[i-1].equals("R")) {
                count_R_base++;
            }
        }

        System.out.println(Math.min(count_B_base, count_R_base));
        br.close();
    }
}
