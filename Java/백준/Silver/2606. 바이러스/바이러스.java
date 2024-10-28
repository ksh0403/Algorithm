import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 (=노드의 수)
        int t = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수 (=간선의 수)

        // 컴퓨터 연결 관계를 저장할 리스트 배열 생성 (1부터 n까지 사용)
        LinkedList<Integer>[] linkedLists = new LinkedList[n + 1];
        for(int i = 1; i <= n; i++){
            linkedLists[i] = new LinkedList<>();
        }

        // 각 컴퓨터 쌍을 읽어와서 연결 정보를 리스트에 저장
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            linkedLists[a].add(b);
            linkedLists[b].add(a);
        }

        // BFS를 통해 연결된 컴퓨터 탐색 시작
        BFS(linkedLists);

        // 컴퓨터 1과 연결된 컴퓨터의 수를 출력 (1번 노드를 제외하기 위해 count - 1)
        System.out.print(count - 1);
        br.close();
    }

    // 너비 우선 탐색(BFS) 함수
    public static void BFS(LinkedList<Integer>[] list) {
        // 방문 여부를 기록할 배열 생성 및 초기화
        boolean[] visited = new boolean[list.length];
        for(int i = 0; i < list.length; i++) {
            visited[i] = false;
        }

        // BFS에 사용할 큐 생성
        Queue<Integer> q = new LinkedList<>();

        // 탐색 시작 노드 설정 (컴퓨터 1번부터 시작)
        int currentNode = 1;

        // 시작 노드를 큐에 추가하고 방문 처리
        q.add(currentNode);
        visited[currentNode] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 현재 노드를 큐에서 꺼내 방문
            currentNode = q.remove();
            count++;

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