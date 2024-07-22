import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 나무의 종류와 개수를 기록할 Map
        Map<String, Double> tree = new HashMap<>();

        // 나무의 전체 개수 (= 테스트케이스의 수)
        long t = 0;

        String input = br.readLine();

        // 입력줄이 존재하는 동안 계속 반복
        while (input != null) {
            // Map에 나무 종이 이미 존재한다면 개수 증가
            if (tree.containsKey(input)) {
                tree.replace(input, tree.get(input) + 1);
            } else {
                // 처음 등록되는 나무 종이라면 개수를 1로 하여 Map에 추가
                tree.put(input, 1.0);
            }

            t++;
            input = br.readLine();
        }

        // ArrayList를 활용해 Key 값을 기준으로 오름차순 정렬
        List<String> keySet_tree = new ArrayList<>(tree.keySet());
        Collections.sort(keySet_tree);

        // 정렬된 순서로 비율을 계산해 StringBuilder 에 쌓기
        for (String key : keySet_tree) {
            // 해당 종이 차지하는 비율 (소수점 4째자리까지 반올림)
            String per = String.format("%.4f", tree.get(key)/t * 100);

            sb.append(key + " " + per).append("\n");
        }

        System.out.println(sb);

        // Reader 버퍼 닫기
        br.close();
    }
}