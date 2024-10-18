import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            // map에 없는 키라면 개수를 0 + 1 로 하여 추가
            // map에 있는 키라면 + 1 하여 해당 값을 대체
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < m; j++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (map.containsKey(num)) {
                sb.append(map.get(num) + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}