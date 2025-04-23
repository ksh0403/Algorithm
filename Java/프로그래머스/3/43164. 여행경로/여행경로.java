import java.util.*;

class Solution {
    List<String> route = new ArrayList<>(); // 최종 정답 경로를 저장할 리스트
    Map<String, PriorityQueue<String>> graph = new HashMap<>(); // 출발지 -> 도착지를 저장할 그래프 (알파벳 순 정렬 위해 PriorityQueue 사용)

    public String[] solution(String[][] tickets) {

        // 1. 항공권 정보로 그래프 구성 (출발지 → 도착지들)
        for (String[] ticket : tickets) {
            String from = ticket[0]; // 출발 공항
            String to = ticket[1];   // 도착 공항

            // 출발지가 처음 등장했다면 우선순위 큐 생성 (자동으로 알파벳 순 정렬됨)
            graph.putIfAbsent(from, new PriorityQueue<>());

            // 도착지를 큐에 추가
            graph.get(from).offer(to);
        }

        // 2. 항상 ICN 공항에서 출발
        dfs("ICN");

        // 3. 리스트를 배열로 변환해서 정답 리턴
        return route.toArray(new String[0]);
    }

    // DFS로 경로 탐색: 도착지를 하나씩 꺼내며 깊이 탐색
    private void dfs(String airport) {
        // 현재 공항에서 출발 가능한 도착지가 여러 개인 경우를 위해 PriorityQueue 사용
        PriorityQueue<String> pq = graph.get(airport);

        // 갈 수 있는 도착지가 더 이상 없을 때까지 반복
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll(); // 알파벳 순으로 가장 빠른 공항부터 꺼냄
            dfs(next);               // 다음 공항으로 재귀 탐색
        }

        /**
         * 🧠 여기서 중요한 포인트:
         * 티켓을 다 사용하고 탐색이 끝난 **그 순간**부터 돌아오면서 경로를 저장해야 함!
         * 그 이유는: 
         * - DFS는 티켓을 다 쓴 시점에만 정답이 확정됨
         * - 그래서 경로를 거꾸로 쌓고 (`add(0, 공항)`) 마지막에 정방향으로 리턴함
         * - 이걸 후위 순회(post-order)라고도 해요
         */
        route.add(0, airport); // 경로를 역순으로 저장
    }
}
