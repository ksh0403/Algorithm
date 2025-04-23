import java.util.*;

class Solution {
    List<String> visited; // 방문 여부 체크 리스트 (방문한 단어를 저장)
    
    public int solution(String begin, String target, String[] words) {
        visited = new ArrayList<>(); // 방문 리스트 초기화
     
        return bfs(begin, target, words);
    }
    
    // BFS 함수
    public int bfs(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>(); // 탐색을 위한 큐 생성
        q.offer(begin); // 시작점 큐에 추가
        visited.add(begin); // 시작점 방문 처리
        
        // 큐가 빌 때까지 반복
        int count = 0;
        while (!q.isEmpty()) {
            // 현재 레벨의 단어 개수만큼 반복 (=현재 큐에 들어 있는 단어 개수만큼)
            for (int i = 0; i < q.size(); i++) {
                // 현재 레벨 단어 중 하나 꺼내기
                String curr = q.poll();
                
                // 해당 단어가 target이면 반복문 종료
                if (curr.equals(target)) {
                    return count; // 단계 카운트값 리턴
                }
                
                // 아직 방문하지 않았고, curr과 한 글자만 다른 단어들 찾기
                for (String word : words) {
                    if (!visited.contains(word) && checkOneDiff(curr, word)) {
                        q.offer(word); // 큐에 추가
                        visited.add(word); // 방문 처리
                    }
                }
            }
            
            // 한 레벨 탐색이 끝났으므로 count 증가
            count++;
        }
        
        // target을 찾지 못하고 종료한 경우
        return 0;
    }
    
    // 두 단어가 한 글자만 다른지 확인하는 함수 (두 단어의 길이가 같다는 전제 하에)
    public boolean checkOneDiff(String a, String b) {
        int count_diff = 0;
        
        // 두 단어를 한 글자씩 비교
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count_diff++; // 다를 경우 ++
            }
        }
        
        // count_diff가 1이면 두 단어는 한 글자만 다른 것이 맞다고 반환 (true)
        return count_diff == 1;
    }
}