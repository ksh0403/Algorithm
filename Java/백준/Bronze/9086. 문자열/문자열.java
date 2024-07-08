import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수 T
        int t = Integer.parseInt(br.readLine());

        // 테스트 케이스를 담을 T 크기의 배열
        String arr[] = new String[t];

        // 첫 글자 + 마지막 글자
        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            arr[i] = line.substring(0, 1) + line.substring(line.length() - 1, line.length());
        }

        // 출력
        for (String ele : arr) {
            bw.write(ele + "\n");
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();

    }
}