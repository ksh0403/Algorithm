import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수의 개수 N
        int n = Integer.parseInt(br.readLine());

        // 둘째 줄 문자열 분리를 위한 StringTokenizer 생성 (공백 기준)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N 크기의 정수 배열 arr
        int arr[] = new int[n];

        // 매 반복마다 반환되는 토큰의 값을 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 찾으려는 정수 V
        int v = Integer.parseInt(br.readLine());
        int count = 0;

        // V 개수 카운트
        for (int i = 0; i < n; i++) {
            if (arr[i] == v) {
                count++;
            }
        }

        // 개수 출력
        // BufferedWriter 출력은 String형으로 변환이 필요함
        bw.write(String.valueOf(count));

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}