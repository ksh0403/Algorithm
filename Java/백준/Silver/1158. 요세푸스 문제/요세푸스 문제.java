import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 분리를 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, K
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // N명의 사람을 담는 LinkedList
        LinkedList<Integer> n_list = new LinkedList<>();

        // 1 ~ N 값을 리스트에 삽입
        for (int i = 1; i <= n; i++) {
            n_list.add(i);
        }

        bw.write("<");
        // 사람이 모두 제거될 때까지 반복 (=N번 반복)
        for (int i = 0; i < n; i++) {
            // 첫 번째 출력을 제외하고 콤마 찍기
            if (i != 0) {
                bw.write(", ");
            }

            // k - 1 번째 (1번째부터 시작하므로) 사람을 찾아 제거하는 과정
            for (int j = 0; j < k; j++) {
                if (j == (k - 1)) {
                    // k - 1 번째 사람이라면 출력하며 리스트에서 제거
                    bw.write(String.valueOf(n_list.remove()));
                } else {
                    // 아직 k - 1 번째 사람이 아니라면 리스트에서 제거하여 맨 뒤로 보냄
                    n_list.add(n_list.remove());
                }
            }
        }
        bw.write(">");

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}