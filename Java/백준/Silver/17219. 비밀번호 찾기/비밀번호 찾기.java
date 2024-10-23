import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String ad = st.nextToken(); // 사이트 주소
            String pw = st.nextToken(); // 비밀번호
            map.put(ad, pw);
        }
        for (int j = 0; j < m; j++) {
            String find = br.readLine();
            if (map.containsKey(find)) {
                sb.append(map.get(find)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}