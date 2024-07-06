import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N, M 문자열 분리를 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // N * M 크기의 2차원 배열(=행렬) A, B 생성
        int arr_a[][] = new int[n][m];
        int arr_b[][] = new int[n][m];

        // 행렬 A
        for (int i = 0; i < n; i++) {
            // 매 행의 문자열 분리를 위한 StringTokenizer
            StringTokenizer st_a = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                arr_a[i][j] = Integer.parseInt(st_a.nextToken());
            }
        }

        // 행렬 B
        for (int i = 0; i < n; i++) {
            // 매 행의 문자열 분리를 위한 StringTokenizer
            StringTokenizer st_b = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                arr_b[i][j] = Integer.parseInt(st_b.nextToken());
            }
        }

        // 두 행렬을 더한 결과 행렬
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(String.valueOf(arr_a[i][j] + arr_b[i][j]) + " ");
            }
            bw.write("\n");
        }

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}