import java.util.*;

class Solution {
    int answer = 0;
    boolean[][] visited; // 방문 여부 체크 배열
    int[][] result; // 각 칸별 최소 거리 저장 배열
    
    // 상하좌우 방향 이동을 위한 배열
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    
    // maps의 크기
    int n;
    int m;
    
    public int solution(int[][] maps) {
        n = maps.length; // maps의 행의 개수
        m = maps[0].length; // maps의 열의 개수
        visited = new boolean[n][m]; // 방문 여부 체크 배열 초기화
        result = new int[n][m]; // 각 칸별 최소 거리 저장 배열 초기화
        
        // BFS 시작 (0, 0 위치부터라고 생각하고 시작)        
        bfs(0, 0, maps);
        
        // 탐색 이후 (n-1, m-1) 위치를 방문했다면 정답 출력, 그렇지 않다면 -1 출력
        if (visited[n-1][m-1]) {
            return result[n-1][m-1] + 1; // 시작 칸 포함이라 +1
        } else {
            return -1;
        }
    }
    
    // BFS 함수
    public void bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>(); // 탐색을 위한 큐 생성 (좌표 x, y 형태로 저장)
        q.offer(new int[] {x, y}); // 시작점 큐에 추가
        visited[x][y] = true; // 시작점 방문 처리
        
        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            // 현재 위치 꺼내기
            int[] curr = q.poll();
            int curr_X = curr[0];
            int curr_Y = curr[1];
            
            // 상하좌우 방향 탐색
            for (int i = 0; i < 4; i++) {
                int next_X = curr_X + dx[i];
                int next_Y = curr_Y + dy[i];
                
                // 1. 범위 벗어나면 건너뜀
                if (next_X < 0 || next_Y < 0 || next_X >= n || next_Y >= m) {
                    continue;
                }
                
                // 2. 이미 방문했거나, 벽이라면 건너뜀
                if (visited[next_X][next_Y] || maps[next_X][next_Y] == 0) {
                    continue;
                }
                
                // 3. 이동 가능한 경우
                q.offer(new int[] {next_X, next_Y}); // 큐에 추가
                visited[next_X][next_Y] = true; // 방문 처리
                result[next_X][next_Y] = result[curr_X][curr_Y] + 1; // 이동한 거리 저장 
            }
        
        }
        
    }
}