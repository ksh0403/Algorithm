import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String temp = st.nextToken();
                String clothes = st.nextToken();
                map.put(clothes, map.getOrDefault(clothes, 0) + 1);
            }

            int result = 1;
            for (String key : map.keySet()) {
                int value = map.get(key);
                result *= (value + 1);
            }
            sb.append(result - 1).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}