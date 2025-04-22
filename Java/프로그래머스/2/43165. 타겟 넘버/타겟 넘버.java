import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        // 큐 생성: 큐의 각 원소는 [현재까지의 합, 현재 인덱스]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // 생성과 동시에 [0, 0]로 초기화한 배열을 큐에 넣음 (탐색을 시작하기 위한 출발점: 합 0, 인덱스 0)
        
        // 큐가 빌 때까지 반복 (BFS 탐색)
        while (!q.isEmpty()) {
            int[] curr = q.poll(); // 큐에서 하나 꺼냄
            int sum = curr[0]; // 현재까지의 누적 합
            int idx = curr[1]; // 현재 처리 중인 인덱스
            
            // 종료 조건: 모든 숫자를 다 사용했을 때
            if (idx == numbers.length) {
                // 타겟 넘버가 만들어졌다면 카운트
                if (sum == target) {
                    answer++;
                }
                
                continue; // 다음 탐색으로 이동
            }
            
            // 다음 숫자를 더하거나 빼는 두 가지 경우 큐에 넣기
            q.offer(new int[]{sum + numbers[idx], idx + 1});
            q.offer(new int[]{sum - numbers[idx], idx + 1});
        }
        
        return answer;    
    }
}