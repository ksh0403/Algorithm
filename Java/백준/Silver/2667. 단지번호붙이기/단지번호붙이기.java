import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = { -1, 1, 0, 0 }; // 상, 하
    static int[] dy = { 0, 0, -1, 1 }; // 좌, 우
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자 '1' → 숫자 1
            }
        }

        // 전체 탐색 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(i, j); // 단지 하나 BFS 탐색
                    result.add(count);     // 단지 집 수 저장
                }
            }
        }

        // 결과 정렬
        Collections.sort(result);

        // 출력
        System.out.println(result.size()); // 단지 수
        for (int r : result) {
            System.out.println(r); // 각 단지의 집 수
        }
    }

    // BFS 함수
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 1; // 현재 단지의 집 개수 (시작점 포함)

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                // 범위 체크 + 미방문 + 집인 경우
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                        count++; // 집 개수 증가
                    }
                }
            }
        }

        return count; // 이 단지에 속한 집의 총 개수 반환
    }
}
