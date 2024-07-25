import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 연산의 개수 N
        long n = Long.parseLong(br.readLine());

        // 절댓값이 작은 수부터 꺼낼 양수용/음수용 우선순위 큐
        // 음수 큐에서는 큰 숫자일수록 절댓값이 작으므로 reverseOrder() 옵션 적용
        PriorityQueue<Long> q_plus = new PriorityQueue<>();
        PriorityQueue<Long> q_minus = new PriorityQueue<>(Collections.reverseOrder());

        for (long i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            // 입력이 양수이면 양수 큐, 음수이면 음수 큐에 추가
            if (num > 0) {
                q_plus.offer(num);
            } else if (num < 0) {
                q_minus.offer(num);
            } else {
                // 입력이 0일 때
                // 두 큐가 모두 빈 경우 0 출력
                if (q_plus.isEmpty() && q_minus.isEmpty()) {
                    sb.append("0").append("\n");
                } else if (q_plus.isEmpty()) {
                    sb.append(q_minus.poll()).append("\n");
                } else if (q_minus.isEmpty()) {
                    sb.append(q_plus.poll()).append("\n");
                } else {
                    // 두 큐 모두 원소를 가지고 있는 경우
                    // 각 큐에서 peek하여 절댓값을 비교한 후 가장 작은 수 출력
                    if (q_plus.peek() < -q_minus.peek()) {
                        sb.append(q_plus.poll()).append("\n");
                    } else if (q_plus.peek() > -q_minus.peek()) {
                        sb.append(q_minus.poll()).append("\n");
                    } else {
                        // 절댓값이 동일할 경우 q_minus 의 원소 출력
                        sb.append(q_minus.poll()).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);

        // Reader 버퍼 닫기
        br.close();
    }
}