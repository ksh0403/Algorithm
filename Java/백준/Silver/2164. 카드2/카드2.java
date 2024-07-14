import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N
        long n = Long.parseLong(br.readLine());

        // N장의 카드를 담을 LinkedList
        LinkedList<Long> n_list = new LinkedList<>();

        // 1~N 값을 리스트에 차례로 추가
        for (long i = 0; i < n; i++) {
            n_list.add(i + 1);
        }

        // 카드가 한 장 남을 때까지 반복
        while (n_list.size() != 1) {
            // 가장 위 카드 버리기
            n_list.removeFirst();
            // 가장 위 카드를 빼서 마지막으로 옮기기
            n_list.addLast(n_list.removeFirst());
        }

        // 마지막 카드 출력
        bw.write(String.valueOf(n_list.get(0)));

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}