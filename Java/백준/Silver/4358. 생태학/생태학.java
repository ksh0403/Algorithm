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

        // input 선언만 밖에서 함
        String input;

        // 입력줄이 존재하는 동안 계속 반복
        while ((input = br.readLine()) != null) {
            // Map에 이미 종이 있다면 개수를 1 증가시키고, 없다면 개수를 0 + 1로 하여 Map에 추가
            tree.put(input, tree.getOrDefault(input, 0.0) + 1);

            t++;
        }

        // ArrayList를 활용해 Key 값을 기준으로 오름차순 정렬
        List<String> keySet_tree = new ArrayList<>(tree.keySet());
        Collections.sort(keySet_tree);

        // 정렬된 순서로 비율을 계산해 StringBuilder 에 쌓기
        for (String key : keySet_tree) {
            // 해당 종이 차지하는 비율 (소수점 4째자리까지 반올림)
            String per = String.format("%.4f", tree.get(key)/t * 100);

            // StringBuilder에 쌓기
            sb.append(key).append(" ").append(per).append("\n");
        }

        System.out.println(sb);

        // Reader 버퍼 닫기
        br.close();
    }
}