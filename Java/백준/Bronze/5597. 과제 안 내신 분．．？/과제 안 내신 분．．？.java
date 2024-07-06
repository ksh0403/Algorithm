import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[30];

        // fill() 메소드를 이용해 arr 배열을 모두 0으로 초기화
        Arrays.fill(arr, 0);

        // 28명의 제출자를 배열에 표시
        for (int i = 0; i < 28; i++) {
            int submit = Integer.parseInt(br.readLine());
            arr[submit - 1] = 1;
        }

        // 배열에서 값이 0인 학생 출석번호 출력
        for (int j = 0; j < 30; j++) {
            if (arr[j] == 0) {
                bw.write(String.valueOf(j + 1) + "\n");
            }
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}