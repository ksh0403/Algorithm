import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값
        String input = br.readLine();

        // 성적
        double score = 0.0;

        // A, B, C, D (F는 그대로 0.0)
        switch (input.substring(0, 1)) {
            case "A":
                score += 4;
                break;
            case "B":
                score += 3;
                break;
            case "C":
                score += 2;
                break;
            case "D":
                score += 1;
                break;
        }

        // +, - 인 경우
        if (input.length() > 1) {
            switch (input.substring(1, 2)) {
                case "+":
                    score += 0.3;
                    break;
                case "-":
                    score -= 0.3;
                    break;
            }
        }

        // 출력
        bw.write(String.valueOf(score));

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}