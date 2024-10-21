import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> s = new ArrayList<>(); // 공집합 S
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();

            // 연산 수행
            if (order.equals("all")) {
                s.clear();
                for (int j = 1; j <= 20; j++) {
                    s.add(j);
                }
            } else if (order.equals("empty")) {
                s.clear();
            } else {
                int x = Integer.parseInt(st.nextToken());
                switch (order) {
                    case "add":
                        if (!s.contains(x)) {
                            s.add(x);
                        }
                        break;
                    case "remove":
                        if (s.contains(x)) {
                            s.remove(s.indexOf(x));
                        }
                        break;
                    case "check":
                        if (s.contains(x)) {
                            sb.append(1 + "\n");
                        } else {
                            sb.append(0 + "\n");
                        }
                        break;
                    case "toggle":
                        if (s.contains(x)) {
                            s.remove(s.indexOf(x));
                        } else {
                            s.add(x);
                        }
                        break;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}