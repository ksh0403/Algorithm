import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // A@B 연산을 하는 함수
    public static long operation(long a, long b) {
        long result = (a + b) * (a - b);
        return result;
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 분리를 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 함수 호출
        bw.write(String.valueOf(operation(a, b)));

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}