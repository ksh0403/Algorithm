import java.io.*;
import java.util.*;

public class Main {
    static int[] checked; // 연결 요소 체크가 완료된 노드들을 담을 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 노드의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        checked = new int[n+1];

        // 각 노드의 연결 관계를 저장할 리스트 배열 lists 생성 (1부터 n까지 사용)
        List<Integer>[] lists = new List[n+1];
        for (int i = 1; i <= n; i++){
            lists[i] = new LinkedList<>(); // 각 요소에 LinkedList 객체를 할당
        }

        // 연결 정보를 리스트에 저장
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lists[u].add(v);
            lists[v].add(u);
        }

        int count = 0; // 연결 요소의 개수 (=덩어리 개수)
        for (int k = 1; k <= n; k++) {
            // 체크가 안되어 있으면 count++하고 BFS를 통해 연결된 노드를 탐색함
            if (checked[k] != 1) {
                count++;
                BFS(lists, k);
            }
        }

        System.out.println(count);
        br.close();
    }

    // 너비 우선 탐색(BFS) 함수
    public static void BFS(List<Integer>[] list, int currentNode) {
        // 방문 여부를 기록할 배열 생성 및 초기화
        boolean[] visited = new boolean[list.length];
        for (int i = 0; i < list.length; i++) {
            visited[i] = false;
        }

        // BFS에 사용할 큐 생성
        Queue<Integer> q = new LinkedList<>();

        // 시작 노드를 큐에 추가하고 방문 처리
        q.add(currentNode);
        visited[currentNode] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 현재 노드를 큐에서 꺼내서 방문
            currentNode = q.remove();
            checked[currentNode] = 1; // 체크한 노드는 배열에 저장

            // 현재 노드와 연결된 모든 노드를 확인
            for (int nextNode : list[currentNode]) {
                // 방문하지 않은 노드를 큐에 추가하고 방문 처리
                if (!visited[nextNode]) {
                    q.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}