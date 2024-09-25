class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int a, b, c;
        
        for (int i = 0; i < nums.length-2; i++) {
            a = nums[i];
            for (int j = i+1; j < nums.length-1; j++) {
                b = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    c = nums[k];
                    int x = a + b + c;
                    if (isPrime(x) == true) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    // 소수 판별 함수
    public boolean isPrime(int x) {
        // 0과 1은 소수가 아님
        if (x == 0 || x == 1) return false;
        
        // 2와 3은 소수임
        if (x == 2 || x == 3) return true;
        
        // 2 또는 3으로 나누어 떨어지면 소수가 아님
        if (x % 2 == 0 || x % 3 == 0) return false;
        
        // 5부터는 소수가 (6k +- 1)의 형태를 가짐
        for (int i = 5; i <= Math.sqrt(x); i += 6) {
            if (x % i == 0 || x % (i+2) == 0) return false;
        }
        
        // 소수는 true 반환
        return true;
    }
}