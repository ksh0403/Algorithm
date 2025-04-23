import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 각 컴퓨터의 방문 여부
        int answer = 0; // 네트워크 개수

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers, visited);
                answer++; // BFS 한 번 돌 때마다 하나의 네트워크 완성
            }
        }

        return answer;
    }

    // BFS로 연결된 컴퓨터들을 방문 처리
    public void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < computers.length; i++) {
                // 연결되어 있고 아직 방문하지 않았다면 큐에 추가
                if (computers[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
