import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int X_count = 0;
        for (int i = 0; i < input.length(); i++) {
            String sub = input.substring(i, i+1);
            if (sub.equals("X")) {
                // "X"가 나온 경우
                X_count++;
                if (X_count == 4) {
                    sb.append("AAAA");
                    X_count = 0;
                }
            } else {
                // "."이 나온 경우
                if (X_count == 4) {
                    sb.append("AAAA.");
                    X_count = 0;
                } else if (X_count == 2) {
                    sb.append("BB.");
                    X_count = 0;
                } else if (X_count != 0) {
                    System.out.println(-1);
                    return;
                } else {
                    sb.append(".");
                }
            }
        }

        // 반복문 종료 후 X_count 확인
        if (X_count == 4) {
            sb.append("AAAA");
            X_count = 0;
        } else if (X_count == 2) {
            sb.append("BB");
            X_count = 0;
        } else if (X_count != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
        br.close();
    }
}
