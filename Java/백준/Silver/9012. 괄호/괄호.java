import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수 T
        long t = Long.parseLong(br.readLine());

        // "(" 를 스택에 넣고 ")" 가 나타나면 pop 하는 방식
        // 스택으로 사용할 LinkedList
        LinkedList<String> s_list = new LinkedList<>();

        // T만큼 반복
        for (long i = 0; i < t; i++) {
            String line = br.readLine();
            boolean flag = true;

            // 각 라인의 길이만큼 반복 (NO일 경우 중도 탈출)
            for (int j = 0; j < line.length(); j++) {
                // "(" 인지 ")" 인지 구분
                if (line.substring(j, j + 1).charAt(0) == '(') {
                    s_list.add("(");
                } else {
                    // 스택 size가 0인데 ")" 가 나타날 경우 : NO
                    if (s_list.size() == 0) {
                        bw.write("NO\n");
                        flag = false;
                        break;
                    } else {
                        // 스택 size가 0이 아니라면
                        // removeLast() : 마지막 노드를 제거하는 메소드
                        s_list.removeLast();
                    }
                }
            }

            // 각 라인 for문 종료 후 flag가 여전히 true라면 실행
            if (flag == true) {
                // - 스택 size가 0이 아닐 경우 [=스택에 "("가 남았을 경우] : NO
                // - 스택이 모두 비워졌다면 비로소 해당 라인은 YES
                if (s_list.size() != 0) {
                    bw.write("NO\n");
                } else {
                    bw.write("YES\n");
                }
            }

            // clear() : LinkedList 를 완전히 비우는 메소드
            s_list.clear();
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}