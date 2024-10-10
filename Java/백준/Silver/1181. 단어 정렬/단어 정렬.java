import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Set<String> uniqueStrings = new HashSet<>();
    String[] arr = new String[n];

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
      uniqueStrings.add(arr[i]);  // 중복을 제거하면서 입력받음
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
