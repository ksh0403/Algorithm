import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수 T 입력받기 (int형으로 변환)
        int t = Integer.parseInt(br.readLine());

        // 각 테스트 케이스, 즉 두 정수의 문자열 분리를 위한 StringTokenizer
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            // 매 반복마다(=라인마다) StringTokenizer 생성과 동시에 문자열 입력받기 (" "를 구분자로 하여 문자열 분리)
            st = new StringTokenizer(br.readLine()," ");

            // StringTokenizer.nextToken()으로 분리된 토큰을 반환하는데,
            // 반환되는 타입이 String이므로 Integer.parseInt()를 통해 int형으로 변환
            // 변환한 두 토큰을 더해준 값을 BufferedWriter.write()에 넣어준다.
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
        }
        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤(flush) 닫기(close)
        bw.flush();
        bw.close();

    }
}