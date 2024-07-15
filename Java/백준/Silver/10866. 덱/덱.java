import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ArrayDeque 를 이용해 덱 구현
        ArrayDeque<Long> deque = new ArrayDeque<>();

        // 명령의 수 N
        long n = Long.parseLong(br.readLine());

        for (long i = 0; i < n; i++) {
            // 문자열 분리를 위한 StringTokenizer
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 각 라인의 첫 번째 토큰을 가져옴
            String token = st.nextToken();

            switch (token) {
                case "push_front":
                    deque.offerFirst(Long.parseLong(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Long.parseLong(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(deque.pollFirst()) + "\n");
                    }
                    break;
                case "pop_back":
                    if (deque.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(deque.pollLast()) + "\n");
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()) + "\n");
                    break;
                case "empty":
                    if (deque.size() == 0) {
                        bw.write(String.valueOf(1) + "\n");
                    } else {
                        bw.write(String.valueOf(0) + "\n");
                    }
                    break;
                case "front":
                    if (deque.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(deque.peekFirst()) + "\n");
                    }
                    break;
                case "back":
                    if (deque.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(deque.peekLast()) + "\n");
                    }
                    break;
            }
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}