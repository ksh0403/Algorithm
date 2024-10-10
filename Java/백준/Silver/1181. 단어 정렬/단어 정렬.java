import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    // HashSet을 사용함으로써 자동으로 중복을 제거하면서 입력받음
    Set<String> uniqueStrings = new HashSet<>();
    for (int i = 0; i < n; i++) {
      uniqueStrings.add(br.readLine());
    }

    // Set을 List로 변환하여 정렬
    List<String> sortedList = new ArrayList<>(uniqueStrings);
    Collections.sort(sortedList, (a, b) -> {
      if (a.length() != b.length()) {
        return Integer.compare(a.length(), b.length());
      } else {
        return a.compareTo(b);  // 길이가 같으면 사전순 정렬
      }
    });

    for (String str : sortedList) {
      sb.append(str).append("\n");
    }

    System.out.print(sb);
    br.close();
  }
}
