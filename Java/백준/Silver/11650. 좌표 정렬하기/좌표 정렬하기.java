import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		// TreeMap을 사용하여 x값 기준으로 자동 정렬되도록 함
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (map.containsKey(x)) {
				// x가 있는 경우 value_list에 값을 추가
				map.get(x).add(y);
			} else {
				// x가 없는 경우 value_list 생성하고 map에 저장
				ArrayList<Integer> value_list = new ArrayList<>();
				value_list.add(y);
				map.put(x, value_list); // put
			}
		}

		// TreeMap (y값 정렬 및) sb에 추가
		Iterator<Integer> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			int key = keys.next();

			if (map.get(key).size() > 1) {
				// value_list의 원소가 하나 이상이면 y값 정렬
				Collections.sort(map.get(key));
				for (int k = 0; k < map.get(key).size(); k++) {
					sb.append(key + " " + map.get(key).get(k)).append("\n");
				}
			} else {
				sb.append(key + " " + map.get(key).get(0)).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}
}