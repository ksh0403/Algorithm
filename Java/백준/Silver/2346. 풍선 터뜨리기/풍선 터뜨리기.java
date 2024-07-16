import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 풍선의 수 N
        long n = Long.parseLong(br.readLine());

        // 1~N 번 풍선을 담을 ArrayDeque
        ArrayDeque<Long> ballon_dq = new ArrayDeque<>();
        for (long i = 0; i < n; i++) {
            ballon_dq.offerLast(i + 1);
        }

        // 문자열 분리를 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1~N 번 풍선의 종이 값을 담을 ArrayDeque
        ArrayDeque<Long> paper_dq = new ArrayDeque<>();
        for (long i = 0; i < n; i++) {
            paper_dq.offerLast(Long.parseLong(st.nextToken()));
        }

        // 다음에 터뜨릴 풍선
        long next = 0;

        for (long i = 0; i < n; i++) {
            if (i == 0) {
                // 처음에는 1번 풍선 터뜨리기
                bw.write(String.valueOf(ballon_dq.pollFirst()) + " ");
                next = paper_dq.pollFirst();
            } else {
                // 이후에는 next 값에 따라 풍선 터뜨리기
                // next가 양수라면 오른쪽으로 돌리고, 음수라면 왼쪽으로 돌림
                if (next > 0) {
                    for (long k = 1; k < next; k++) {
                        ballon_dq.offerLast(ballon_dq.pollFirst());
                        paper_dq.offerLast(paper_dq.pollFirst());
                    }
                    bw.write(String.valueOf(ballon_dq.pollFirst()) + " ");
                    next = paper_dq.pollFirst();
                } else {
                    for (long k = 1; k < -next; k++) {
                        ballon_dq.offerFirst(ballon_dq.pollLast());
                        paper_dq.offerFirst(paper_dq.pollLast());
                    }
                    bw.write(String.valueOf(ballon_dq.pollLast()) + " ");
                    next = paper_dq.pollLast();
                }
            }
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}