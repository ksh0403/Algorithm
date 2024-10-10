import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int max_length = 0;
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
      if (max_length < arr[i].length()) {
        max_length = arr[i].length();
      }
    }
  
    ArrayList<String> list = new ArrayList<>();
    for (int i = 1; i <= max_length; i++) { // max_length 까지만 반복
      ArrayList<String> mini_list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (arr[j].length() == i) {
          if (!mini_list.contains(arr[j])) {
            // mini_list 내에 해당 요소가 없으면 add (중복 방지)
            mini_list.add(arr[j]);
          }
        }
      }
      // 한 길이가 끝날 때마다 mini_list를 정렬하여 list에 합침
      // ArrayList를 정렬하기 위해 Collections.sort() 사용
      Collections.sort(mini_list);
      for (String ele : mini_list) {
        list.add(ele);
      }
    }

    // 출력
    for (String ele : list) {
      System.out.println(ele);
    }
    br.close();
  }
}