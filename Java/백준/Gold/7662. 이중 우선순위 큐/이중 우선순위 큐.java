import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트데이터의 수 T
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int k = Integer.parseInt(br.readLine());

            // Map을 이용해 숫자와 해당 숫자의 개수를 저장
            // TreeMap : 이진트리를 기반으로 오름차순으로 정렬되는 Map
            TreeMap<Integer, Integer> q = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                // 공백을 기준으로 입력문자열을 나눠 배열에 저장
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                // I, D에 따라 연산 처리
                if (ch == 'I') {
                    // q에 없는 키라면 개수를 0 + 1 로 하여 추가
                    // q에 있는 키라면 + 1 하여 해당 값을 대체
                    q.put(n, q.getOrDefault(n, 0) + 1);
                } else {
                    // q가 비어있는데 D 연산이 나오면 무시
                    if (q.size() == 0)
                        continue;

                    // q에 원소가 있을 경우
                    // 개수를 줄일 키인 num : n이 1이면 최댓값[laskKey()], 아니면 최솟값[firstKey()]
                    int num = n == 1 ? q.lastKey() : q.firstKey();

                    // num의 개수(value)를 1 감소시킨다.
                    // 만약 1이라면 Map에서 삭제시킴
                    if (q.put(num, q.get(num) - 1) == 1)
                        q.remove(num);
                }
            }

            // q가 비어있다면 EMPTY, 그렇지 않다면 최댓값과 최솟값을 출력한다.
            System.out.println(q.size() == 0 ? "EMPTY" : q.lastKey() + " " + q.firstKey());
        }

        // Reader 버퍼 닫기
        br.close();
    }
}