import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 각 입력줄을 저장할 리스트 생성
        List<String> list = new ArrayList<>();

        // 다음 입력줄이 없을 때까지 반복
        // 읽어온 줄은 변수 line 에 담아서 사용
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        // 리스트에 담긴 입력줄을 차례로 출력
        for (String ele : list) {
            bw.write(ele + "\n");
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();

    }
}