import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        ArrayList<String> result = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            String input = br.readLine();
            if (set.contains(input)) {
                result.add(input);
            }
        }
        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for (String ele : result) {
            sb.append(ele).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}