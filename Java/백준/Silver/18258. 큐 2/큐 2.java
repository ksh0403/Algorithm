import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Long> q_list = new LinkedList<>();

        // 명령의 수 N
        long n = Long.parseLong(br.readLine());

        // 명령 수행
        for (long i = 0; i < n; i++) {
            String line = br.readLine();

            switch (line.substring(0, 3)) {
                case "pus":
                    StringTokenizer st = new StringTokenizer(line, " ");
                    String p = st.nextToken(); // x 토큰을 꺼내기 위한 임시 토큰
                    long x = Long.parseLong(st.nextToken());
                    q_list.add(x);
                    break;
                case "pop":
                    if (q_list.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(q_list.remove(0)) + "\n");
                    }
                    break;
                case "siz":
                    bw.write(String.valueOf(q_list.size()) + "\n");
                    break;
                case "emp":
                    if (q_list.size() == 0) {
                        bw.write(String.valueOf(1) + "\n");
                    } else {
                        bw.write(String.valueOf(0) + "\n");
                    }
                    break;
                case "fro":
                    if (q_list.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(q_list.get(0)) + "\n");
                    }
                    break;
                case "bac":
                    if (q_list.size() == 0) {
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(q_list.get(q_list.size() - 1)) + "\n");
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