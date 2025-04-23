import java.util.*;

class Solution {
    List<String> route = new ArrayList<>();
    Map<String, PriorityQueue<String>> graph = new HashMap<>();

    public String[] solution(String[][] tickets) {
        // 1. 그래프 구성: 출발지 -> 도착지 리스트 (사전순 정렬되도록 PriorityQueue 사용)
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }

        // 2. DFS 탐색 시작
        dfs("ICN");

        // 3. List를 배열로 변환하여 반환
        return route.toArray(new String[0]);
    }

    // DFS 함수 (역순으로 경로를 저장)
    public void dfs(String airport) {
        PriorityQueue<String> pq = graph.get(airport);

        // 더 이상 갈 곳이 없을 때까지 재귀적으로 탐색
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll()); // 사전순으로 가장 앞선 공항부터 방문
        }

        // 경로를 역순으로 저장 (post-order)
        route.add(0, airport);
    }
}
