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

            // 맵에서 value를 가져와 리스트로 변환
            ArrayList<Integer> list = new ArrayList<>();
            for (String key : map.keySet()) {
                int value = map.get(key);
                list.add(value);
            }

            int result = 1;
            for (int k = 0; k < list.size(); k++) {
                result *= (list.get(k) + 1);
            }
            sb.append(result - 1).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}