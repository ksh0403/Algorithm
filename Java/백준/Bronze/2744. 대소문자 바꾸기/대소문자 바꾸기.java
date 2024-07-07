import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력으로 주어진 단어
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            // 단어의 각 글자의 아스키 코드 값
            int ascii = (int) word.substring(i, i + 1).charAt(0);

            if (ascii >= 65 && ascii <= 90) {
                // 대문자 -> 소문자
                bw.write(word.substring(i, i + 1).toLowerCase());
            } else if (ascii >= 97 && ascii <= 122) {
                // 소문자 -> 대문자
                bw.write(word.substring(i, i + 1).toUpperCase());
            }
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}