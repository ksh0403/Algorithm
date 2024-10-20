import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.addLast(i);
        }

        // 사람이 모두 제거될 때까지(=n번) 반복
        for (int i = 0; i < n; i++) {
            // k번째 사람 제거
            for (int j = 1; j <= k; j++) {
                if (j == k) { // k번째 사람이면 제거
                    if (i == 0) { // 첫 번째 반복이면 < 추가
                        sb.append("<" + q.removeFirst());
                    } else {
                        sb.append(", " + q.removeFirst());
                    }
                } else { // k번째 사람이 아니면 제거하지 않고 가장 뒤로 보냄
                    q.addLast(q.removeFirst());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}