import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int[] s = new int[21]; // 21 크기의 배열 S (원소는 모두 0)
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();

            if (order.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    s[j] = j;
                }
            } else if (order.equals("empty")) {
                for (int j = 1; j <= 20; j++) {
                    s[j] = 0;
                }
            } else {
                int x = Integer.parseInt(st.nextToken());
                switch (order) {
                    case "add":
                        if (s[x] != x) {
                            s[x] = x;
                        }
                        break;
                    case "remove":
                        if (s[x] == x) {
                            s[x] = 0;
                        }
                        break;
                    case "check":
                        if (s[x] == x) {
                            sb.append(1 + "\n");
                        } else {
                            sb.append(0 + "\n");
                        }
                        break;
                    case "toggle":
                        if (s[x] == x) {
                            s[x] = 0;
                        } else {
                            s[x] = x;
                        }
                        break;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}