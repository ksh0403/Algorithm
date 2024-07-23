import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N
        long n = Long.parseLong(br.readLine());

        // N^2 개의 수를 담는 PriorityQueue (우선순위 큐)
        // 우선순위가 높은 숫자가 먼저 나온다. [reverseOrder() : 큰 숫자부터]
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (long i = 0; i < n; i++) {
            // 문자열 분리를 위한 StringTokenizer
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (long j = 0; j < n; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
        }

        // N번째 큰 수
        for (long i = 0; i < n-1; i++) {
            pq.poll();
        }
        sb.append(pq.poll());

        System.out.println(sb);

        // Reader 버퍼 닫기
        br.close();
    }
}