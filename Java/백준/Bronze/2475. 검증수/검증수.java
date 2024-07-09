import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 검증수 계산 함수
    public static long num_v(long a, long b, long c, long d, long e) {
        long result = (a*a + b*b + c*c + d*d + e*e) % 10;
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
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());

        // 함수 호출 후 결과 출력
        bw.write(String.valueOf(num_v(a, b, c, d, e)));

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}