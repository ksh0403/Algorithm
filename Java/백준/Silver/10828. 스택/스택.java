import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // LinkedList 로 스택 구현
        LinkedList<Long> s_list = new LinkedList<>();

        // 명령의 수 N
        long n = Long.parseLong(br.readLine());

        for (long i = 0; i < n; i++) {
            String line = br.readLine();

            switch (line.substring(0, 3)) {
                case "pus":
                    StringTokenizer st = new StringTokenizer(line, " ");

                    String p = st.nextToken(); // x를 얻기 위한 임시 토큰
                    Long x = Long.parseLong(st.nextToken());

                    s_list.add(x);
                    break;
                case "pop":
                    if (s_list.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        // 리스트의 뒤쪽을 스택의 열린 입구라고 생각
                        // pollLast() : 마지막 노드를 반환하며 제거하는 메소드
                        bw.write(String.valueOf(s_list.pollLast()) + "\n");
                    }
                    break;
                case "siz":
                    bw.write(String.valueOf(s_list.size()) + "\n");
                    break;
                case "emp":
                    if (s_list.size() == 0) {
                        bw.write(String.valueOf(1) + "\n");
                    } else {
                        bw.write(String.valueOf(0) + "\n");
                    }
                    break;
                case "top":
                    if (s_list.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        // getLast() : 마지막 노드를 반환하는 메소드
                        bw.write(String.valueOf(s_list.getLast()) + "\n");
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