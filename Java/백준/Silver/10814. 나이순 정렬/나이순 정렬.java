import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      if (map.containsKey(age)) {
        // age 값에 해당하는 키가 이미 있으면 name을 value_list에 추가함
        map.get(age).add(name);
      } else {
        // 키가 없으면 value_list를 생성하고 map에 저장
        ArrayList<String> value_list = new ArrayList<>();
        value_list.add(name);

        map.put(age, value_list); // put
      }
    }

    Iterator<Integer> keys = map.keySet().iterator();
    while (keys.hasNext()) {
      int key = keys.next();
      for (int i = 0; i < map.get(key).size(); i++) {
        sb.append(key + " " + map.get(key).get(i)).append("\n");
      }
    }
    
    System.out.print(sb);
    br.close();
  }
}
