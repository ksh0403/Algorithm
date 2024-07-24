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

        // PriorityQueue 를 이용해 최대 힙 구현
        // reverseOrder() == 큰 숫자부터 꺼내짐 == 최대 힙
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 연산의 개수 N
        long n = Long.parseLong(br.readLine());

        for (long i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.equals("0")) {
                // 입력이 0이면 배열에서 가장 큰 값을 출력하고 제거
                // 배열이 비어 있을 경우 0 출력
                if (maxHeap.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(maxHeap.poll()).append("\n");
                }
            } else {
                // 입력이 0이 아니면 해당 값을 추가
                maxHeap.offer(Long.parseLong(input));
            }
        }

        System.out.println(sb);

        // Reader 버퍼 닫기
        br.close();
   }
}