import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] edge = new int[3];
        for (int i = 0; i < 3; i++) {
            edge[i] = Integer.parseInt(st.nextToken());
        }

        while (edge[0] != 0 && edge[1] != 0 && edge[2] != 0) {
            Arrays.sort(edge);
            if ((edge[0]*edge[0] + edge[1]*edge[1]) == edge[2]*edge[2]) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");

            // 다음 세변 입력받기
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 3; i++) {
                edge[i] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(sb);
        br.close();
    }
}