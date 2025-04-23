class Solution {
    int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int idx, int sum) {
        // 종료조건: numbers의 숫자를 모두 사용했을 때
        if (idx == numbers.length) {
            // 숫자를 조합한 총 합이 타겟 넘버이면 정답 카운트
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, idx+1, sum + numbers[idx]);
        dfs(numbers, target, idx+1, sum - numbers[idx]);
    }
}