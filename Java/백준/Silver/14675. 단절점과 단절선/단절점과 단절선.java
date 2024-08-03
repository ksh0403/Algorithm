import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 정점의 개수 N
        int n = Integer.parseInt(br.readLine());

        // 간선 정보를 담을 n+1 크기의 ArrayList 생성
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++) {
            // list의 각 인덱스(1~n)에 ArrayList를 생성한다.
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;

        // N-1 만큼 반복 (간선의 정보)
        for(int i = 0; i < n - 1; i++) {
            // 간선의 정보를 list에 저장한다.
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a 정점과 연결된 정점 리스트에 b를 추가
            list[a].add(b);
            // b 정점과 연결된 정점 리스트에 a를 추가
            list[b].add(a);
        }

        // 질의의 개수 q
        int q = Integer.parseInt(br.readLine());

        // q만큼 반복
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            if (t == 2) {
                // 간선이 없어지는 경우 (=t가 2인 경우) 트리는 2개의 그래프로 나눠질 수 밖에 없음
                // 따라서 k 값에 관계없이 k번째 간선은 단절선이므로 yes 출력
                sb.append("yes\n");
            } else {
                // 정점이 없어지는 경우 (=t가 1인 경우)
                int k = Integer.parseInt(st.nextToken());
                if (list[k].size() >= 2) {
                    // 없어지는 정점의 간선이 2개 이상이면 트리는 2개 이상의 그래프로 나누어짐
                    // ex) 간선이 2개인 정점을 없애면 2개의 그래프가 생김
                    // ex) 간선이 3개인 정점을 없애면 3개의 그래프가 생김
                    // 따라서 k번째 정점은 단절점이므로 yes 출력
                    sb.append("yes\n");
                } else {
                    // 없어지는 정점의 간선이 1개이면 (=리프노드이면) 해당 정점이 없어지더라도 트리는 여전히 1개의 그래프임
                    // 따라서 단절점이 아니므로 no 출력
                    sb.append("no\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}