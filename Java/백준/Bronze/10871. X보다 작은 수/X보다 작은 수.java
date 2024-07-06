import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 분리를 위한 StringTokenizer (공백 기준)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 수열 A를 담는 N 크기의 정수 배열 arr
        int arr[] = new int[n];

        // 둘째 줄(=수열 A) 문자열 분리를 위한 새로운 StringTokenizer 생성 (공백 기준)
        StringTokenizer st_2 = new StringTokenizer(br.readLine(), " ");

        // 매 반복마다 반환되는 토큰의 값을 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st_2.nextToken());
        }

        // 수열 A의 원소가 X보다 작은 경우만 출력하기
        for (int i = 0; i < n; i++) {
            if (arr[i] < x) {
                bw.write(arr[i] + " ");
            }
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤(flush) 닫기(close)
        bw.flush();
        bw.close();
    }
}