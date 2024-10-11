import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(list);
    for (int ele : list) {
      sb.append(ele).append("\n");
    }
    System.out.print(sb);
    br.close();
  }
}