import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N, M
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // 집합 S
        Set<String> s = new HashSet<>();
        for (long i = 0; i < n; i++) {
            s.add(br.readLine());
        }

        long count = 0;

        // 집합에 포함된 데이터의 개수 세기
        for (long j = 0; j < m; j++) {
            String input = br.readLine();

            if (s.contains(input)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}